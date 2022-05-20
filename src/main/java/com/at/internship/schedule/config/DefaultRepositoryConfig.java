package com.at.internship.schedule.config;

import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class DefaultRepositoryConfig {
    public static final String DEFAULT_REPOSITORY = "${com.at.internship.default.repository}";
    public static final String BEAN_CONTACT_REPOSITORY = "defaultContactRepository";
    public static final String BEAN_APPOINTMENT_REPOSITORY = "defaultAppointmentRepository";
//    public static final String PATH_CONFIGURATION_PACKAGE = "com.at.internship.schedule.config";
//    public static final String PATH_CONFIGURATION_PACKAGE = "com.at.internship.schedule.config.%s%s";
    private static ApplicationContext context;

    @Value(DEFAULT_REPOSITORY)
    private static String defaultRepository;


    public DefaultRepositoryConfig(ApplicationContext context) {
        this.context = context;
        //this.context = new AnnotationConfigApplicationContext(PATH_CONFIGURATION_PACKAGE);
        //this.context = new AnnotationConfigApplicationContext(String.format(PATH_CONFIGURATION_PACKAGE, defaultRepository,"RepositoryConfig.class"));
        //this.context.getBean("s");
    }

    @Bean(name = BEAN_CONTACT_REPOSITORY)
    public IContactRepository defaultContactRepository(){
        return (IContactRepository) context.getBean(defaultRepository.toLowerCase(Locale.ROOT)+"ContactRepository");
    }

    @Bean(name = BEAN_APPOINTMENT_REPOSITORY)
    public IAppointmentRepository defaultAppointmentRepository(){
        return (IAppointmentRepository) context.getBean(defaultRepository.toLowerCase(Locale.ROOT)+"AppointmentRepository");
    }

}
