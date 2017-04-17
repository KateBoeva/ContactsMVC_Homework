package ru.itis.hw.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import ru.itis.hw.contacts.dao.models.dto.ContactDto;
import ru.itis.hw.contacts.service.ContactService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactService mContactService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/contact/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hi(){
        return new ResponseEntity<String>(mContactService.hi(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ResponseEntity<List<ContactDto>> getAllContacts(@RequestHeader(value = "ORIGIN") String origin){
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity<List<ContactDto>>(mContactService.getContacts(), headers, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContactDto> getContactById(@RequestHeader(value = "ORIGIN") String origin,
                                                           @PathVariable("id") int id){
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity<ContactDto>(mContactService.getContact(id), headers, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ResponseEntity createContact(@RequestHeader(value = "ORIGIN") String origin,
                                        @RequestBody ContactDto contactDto){
        mContactService.createContact(contactDto);
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity(headers, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/contact", method = RequestMethod.PUT)
    public ResponseEntity<List<ContactDto>> updateContact(@RequestHeader(value = "ORIGIN") String origin,
                                                          @RequestBody ContactDto contactDto){
        mContactService.updateContact(contactDto);
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity<List<ContactDto>>(mContactService.getContacts(), headers, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public void removeContact(@RequestHeader(value = "ORIGIN") String origin,
                              @PathVariable("id") int id){
        mContactService.removeContact(id);
    }

    private MultiValueMap<String, String> prepareHeadersWithAllow(String origin) {
        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.set("Access-Control-Allow-Origin", "*");
        return headers;
    }

}
