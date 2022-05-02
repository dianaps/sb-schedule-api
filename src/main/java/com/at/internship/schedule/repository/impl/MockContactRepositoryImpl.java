package com.at.internship.schedule.repository.impl;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.repository.IContactRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockContactRepositoryImpl implements IContactRepository {
    private static final List<Contact> CONTACT_LIST;

    static {
        CONTACT_LIST = new ArrayList<>();

        Contact contact;

        contact = new Contact();
        contact.setId(1);
        contact.setFirstName("Juan");
        contact.setLastName("Valle");
        contact.setEmailAddress("jvalle12@gmail.com");
        contact.setPhoneNumber("1234567890");
        contact.setBirthDay(LocalDate.of(1985, 5, 25));
        CONTACT_LIST.add(contact);

        contact = new Contact();
        contact.setId(2);
        contact.setFirstName("Rosa");
        contact.setLastName("Aguilar");
        contact.setEmailAddress("raguilar22@gmail.com");
        contact.setPhoneNumber("0987654321");
        contact.setBirthDay(LocalDate.of(1986, 2, 15));
        CONTACT_LIST.add(contact);

        contact = new Contact();
        contact.setId(3);
        contact.setFirstName("Hector");
        contact.setLastName("Rosado");
        contact.setEmailAddress("hector.rosado@gmail.com");
        contact.setPhoneNumber("1111111111");
        contact.setBirthDay(LocalDate.of(1997, 2, 15));
        CONTACT_LIST.add(contact);

        contact = new Contact();
        contact.setId(4);
        contact.setFirstName("Gonzalo");
        contact.setLastName("Perez");
        contact.setEmailAddress("gperez9@gmail.com");
        contact.setPhoneNumber("9999999999");
        contact.setBirthDay(LocalDate.of(1991, 5, 22));
        CONTACT_LIST.add(contact);

        contact = new Contact();
        contact.setId(5);
        contact.setFirstName("Diana");
        contact.setLastName("Marin");
        contact.setEmailAddress("dmarin@gmail.com");
        contact.setPhoneNumber("5555555555");
        contact.setBirthDay(LocalDate.of(2013, 9, 1));
        CONTACT_LIST.add(contact);
    }

    @Override
    public List<Contact> findAll() {
        return CONTACT_LIST.stream().map(Contact::new).collect(Collectors.toList());
    }
}
