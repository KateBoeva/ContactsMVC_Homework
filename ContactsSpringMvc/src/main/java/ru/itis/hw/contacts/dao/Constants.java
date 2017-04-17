package ru.itis.hw.contacts.dao;

public class Constants {

    static final String SQL_GET_CONTACTS =
            "SELECT * FROM \"Contacts\"";

    static final String SQL_GET_CONTACT =
            "SELECT * FROM \"Contacts\" WHERE id = :id";

    static final String SQL_ADD_CONTACT =
            "INSERT INTO \"Contacts\"(name, number, email, address) " +
                    "VALUES (:name, :number, :email, :address)";

    static final String SQL_UPDATE_CONTACT =
            "UPDATE \"Contacts\" SET name = :name, address = :address, email = :email, number = :number WHERE id = :id";

    static final String SQL_REMOVE_CONTACT =
            "DELETE FROM \"Contacts\" WHERE id = :id";
}
