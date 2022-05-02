package com.at.internship.schedule.repository.impl;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.repository.IAppointmentRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockAppointmentRepositoryImpl implements IAppointmentRepository {

    private static final List<Appointment> APPOINTMENT_LIST;

    static {
        APPOINTMENT_LIST = new ArrayList<>();
        Appointment appointment;

        appointment = new Appointment();
        appointment.setId(1);
        appointment.setContactId(1);
        appointment.setSubject("Breakfast");
        appointment.setTime(LocalDateTime.parse("2022-03-24T10:00:00.0"));
        APPOINTMENT_LIST.add(appointment);

        appointment = new Appointment();
        appointment.setId(2);
        appointment.setContactId(3);
        appointment.setSubject("Say hello");
        appointment.setTime(LocalDateTime.parse("2022-03-24T12:00:00.0"));
        APPOINTMENT_LIST.add(appointment);
    }

    public List<Appointment> findAll() {
        return APPOINTMENT_LIST.stream().map(Appointment::new).collect(Collectors.toList());
    }

}
