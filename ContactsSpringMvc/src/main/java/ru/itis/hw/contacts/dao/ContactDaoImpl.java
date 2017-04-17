package ru.itis.hw.contacts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.hw.contacts.dao.models.Contact;
import ru.itis.hw.contacts.dao.utils.ParamsMapper;
import ru.itis.hw.contacts.dao.utils.SqlQueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SqlQueryExecutor mSqlQueryExecutor;
    @Autowired
    private ParamsMapper mParamsMapper;

    static final RowMapper<Contact> CONTACT_ROW_MAPPER = new RowMapper<Contact>() {
        @Override
        public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new Contact(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("number"),
                        resultSet.getString("email"), resultSet.getString("address"));
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };

    @Override
    public List<Contact> getContacts() {
        return mSqlQueryExecutor.queryForObjects(Constants.SQL_GET_CONTACTS, CONTACT_ROW_MAPPER);
    }

    @Override
    public Contact getContact(int id) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id"), asList(id));
        return mSqlQueryExecutor.queryForObject(Constants.SQL_GET_CONTACT, paramMap, CONTACT_ROW_MAPPER);
    }

    @Override
    public void addContact(Contact contact) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("name", "number", "email", "address"),
                asList(contact.getName(), contact.getNumber(), contact.getEmail(), contact.getAddress()));
        mSqlQueryExecutor.updateQuery(Constants.SQL_ADD_CONTACT, paramMap);
    }

    @Override
    public void updateContact(Contact contact) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("name", "number", "email", "address", "id"),
                asList(contact.getName(), contact.getNumber(), contact.getEmail(), contact.getAddress(), contact.getId()));
        mSqlQueryExecutor.updateQuery(Constants.SQL_UPDATE_CONTACT, paramMap);
    }

    @Override
    public void deleteContact(int id) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id"), asList(id));
        mSqlQueryExecutor.updateQuery(Constants.SQL_REMOVE_CONTACT, paramMap);
    }
}
