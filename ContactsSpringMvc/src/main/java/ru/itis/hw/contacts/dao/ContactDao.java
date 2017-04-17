package ru.itis.hw.contacts.dao;

import ru.itis.hw.contacts.dao.models.Contact;

import java.util.List;

public interface ContactDao {


    List<Contact> getContacts();


    Contact getContact(int id);

    void addContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(int id);
}
