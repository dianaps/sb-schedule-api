package com.at.internship.schedule.repository.impl;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.domain.Contact;
import com.at.internship.lib.repository.AbstractRepository;
import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.serialization.csv.AppointmentSerializer;

import java.time.LocalDate;
import java.util.List;

public class CsvAppointmentRepositoryImpl extends AbstractRepository<Appointment, Integer> implements IAppointmentRepository {
    private static int ID_SEQUENCE = 0;
    private static CsvAppointmentRepositoryImpl SINGLETON;

    public static CsvAppointmentRepositoryImpl getSingleton() {
        if(SINGLETON == null) SINGLETON = new CsvAppointmentRepositoryImpl();
        return SINGLETON;
    }

    private CsvContactRepositoryImpl contactRepository;

    private CsvAppointmentRepositoryImpl() {
        super(new AppointmentSerializer());
    }

    private CsvContactRepositoryImpl getContactRepository() {
        if(contactRepository == null)
            contactRepository = CsvContactRepositoryImpl.getSingleton();
        return contactRepository;
    }

    public List<Appointment> findAllByDate(LocalDate date) {
        return findAll(c -> date.isEqual(c.getTime().toLocalDate()));
    }

    private class InnerAppointment extends Appointment {
        private boolean contactLoaded = false;

        private InnerAppointment(Appointment source) {
            super(source);
        }

        public Contact getContact() {
            if(!contactLoaded) {
                if(super.getContact() == null && getContactId() != null)
                    setContact(getContactRepository().findOne(getContactId()).orElse(null));
                contactLoaded = true;
            }

            return super.getContact();
        }
    }

    @Override
    protected Appointment cloneRow(Appointment source) {
        return new InnerAppointment(source);
    }

    @Override
    protected Integer getId(Appointment source) {
        return source.getId();
    }

    @Override
    protected void assignId(Appointment newRow) {
        newRow.setId(++ID_SEQUENCE);
    }
}
