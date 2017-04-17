package ru.itis.hw.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.hw.contacts.dao.ContactDao;
import ru.itis.hw.contacts.dao.models.Contact;
import ru.itis.hw.contacts.dao.models.dto.ContactDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactDao mContactDao;

    @Override
    public String hi(){
        return "Hello";
    }

    @Override
    public List<ContactDto> getContacts() {
        List<Contact> contacts = mContactDao.getContacts();

        List<ContactDto> contactsDto = new ArrayList<>();
        for (Contact contact : contacts) {
            ContactDto contactDto = new ContactDto();
            contactDto.setId(contact.getId());
            contactDto.setName(contact.getName());
            contactDto.setAddress(contact.getAddress());
            contactDto.setEmail(contact.getEmail());
            contactDto.setNumber(contact.getNumber());
            contactsDto.add(contactDto);
        }

        return contactsDto;
    }

    @Override
    public ContactDto getContact(int id) {
        Contact contact = mContactDao.getContact(id);
        return new ContactDto(contact);
    }

    @Override
    public void createContact(ContactDto contactDto) {
        Contact contact = new Contact(contactDto.getName(), contactDto.getNumber(), contactDto.getEmail(), contactDto.getAddress());
        mContactDao.addContact(contact);
    }

    @Override
    public void updateContact(ContactDto contactDto) {
        Contact contact = new Contact(contactDto.getId(), contactDto.getName(), contactDto.getNumber(), contactDto.getEmail(), contactDto.getAddress());
        mContactDao.updateContact(contact);
    }

    @Override
    public void removeContact(int id) {
        mContactDao.deleteContact(id);
    }
}
