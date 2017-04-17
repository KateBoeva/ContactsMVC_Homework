package ru.itis.hw.contacts.service;

import ru.itis.hw.contacts.dao.models.dto.ContactDto;

import java.util.List;

public interface ContactService {

    String hi();

    List<ContactDto> getContacts();

    ContactDto getContact(int id);

    void createContact(ContactDto contactDto);

    void updateContact(ContactDto contactDto);

    void removeContact(int id);

}
