package com.controllers;

import com.entities.Contact;
import com.repositories.ContactRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {
    private ContactRepository contactRepository;

  public ContactController(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  public List<Contact> getContacts(){
   return contactRepository.findAll();
  }

  public List<Contact> getContactsForPatient(Long id){
    return contactRepository.findContactByPatientId(id);
  }

  public Contact addContact(Contact contact){
    return contactRepository.save(contact);
  }

}
