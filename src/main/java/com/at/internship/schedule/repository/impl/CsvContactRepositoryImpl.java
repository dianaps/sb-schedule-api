package com.at.internship.schedule.repository.impl;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.lib.repository.AbstractRepository;
import com.at.internship.schedule.repository.IContactRepository;
import com.at.internship.schedule.serialization.csv.ContactSerializer;
import com.at.internship.lib.specification.SpecificationUtils;

import java.util.List;

public class CsvContactRepositoryImpl extends AbstractRepository<Contact, Integer> implements IContactRepository {
    private static int ID_SEQUENCE = 0;
    private static CsvContactRepositoryImpl SINGLETON;

    public static CsvContactRepositoryImpl getSingleton() {
        if(SINGLETON == null) SINGLETON = new CsvContactRepositoryImpl();
        return SINGLETON;
    }

    CsvContactRepositoryImpl() {
        super(new ContactSerializer());
        ID_SEQUENCE = findAll().stream().map(Contact::getId).max(Integer::compare).orElse(0);
    }

    public List<Contact> findAllByName(String name) {
        return findAll(c -> SpecificationUtils.like(String.format("%s %s", c.getFirstName(), c.getLastName()), name));
    }

    @Override
    protected Contact cloneRow(Contact source) {
        return new Contact(source);
    }

    @Override
    protected Integer getId(Contact source) {
        return source.getId();
    }

    @Override
    protected void assignId(Contact newRow) {
        newRow.setId(++ID_SEQUENCE);
    }
}
