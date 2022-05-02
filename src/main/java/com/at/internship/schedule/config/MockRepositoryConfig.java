package com.at.internship.schedule.config;

import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.IContactRepository;
import com.at.internship.schedule.repository.impl.MockAppointmentRepositoryImpl;
import com.at.internship.schedule.repository.impl.MockContactRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockRepositoryConfig {

    public static final String BEAN_CONTACT_REPOSITORY = "mockContactRepository";
    public static final String BEAN_APPOINTMENT_REPOSITORY = "mockAppointmentRepository";

    @Bean(name = BEAN_CONTACT_REPOSITORY)
    public IContactRepository mockContactRepository(){
        return new MockContactRepositoryImpl();
    }

    @Bean(name = BEAN_APPOINTMENT_REPOSITORY)
    public IAppointmentRepository mockAppointmentRepository(){
        return new MockAppointmentRepositoryImpl();
    }

}
