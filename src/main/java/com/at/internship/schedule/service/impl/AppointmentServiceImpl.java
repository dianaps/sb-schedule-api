package com.at.internship.schedule.service.impl;

import com.at.internship.schedule.config.DefaultRepositoryConfig;
import com.at.internship.schedule.config.MockRepositoryConfig;
import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.impl.MockAppointmentRepositoryImpl;
import com.at.internship.schedule.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final IAppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(
            @Qualifier(DefaultRepositoryConfig.BEAN_APPOINTMENT_REPOSITORY)
            IAppointmentRepository appointmentRepository
    ) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

}
