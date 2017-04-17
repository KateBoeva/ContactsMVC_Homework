package ru.itis.hw.contacts.dao.models.dto;

import ru.itis.hw.contacts.dao.models.Contact;

/**
 * Created by katemrrr on 26.03.17.
 */
public class ContactDto {

    private int id;
    private String name;
    private String number;
    private String email;
    private String address;

    public ContactDto() {
    }

    public ContactDto(int id) {
        this.id = id;
    }

    public ContactDto(Contact contact){
        id = contact.getId();
        name = contact.getName();
        number = contact.getNumber();
        email = contact.getEmail();
        address = contact.getAddress();
    }

    public ContactDto(int id, String name, String number, String email, String address) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
