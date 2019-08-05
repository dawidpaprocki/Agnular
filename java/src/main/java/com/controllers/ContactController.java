package com.controllers;

import com.entities.Contact;
import com.repositories.ContactRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {
    private ContactRepository contactRepository;

  public ContactController(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }
  @GetMapping("/contacts")
  public List<Contact> getContacts(){
   return contactRepository.findAll();
  }
  @GetMapping("/contacts/{id}")
  public List<Contact> getContactsForPatient(@PathVariable Long id){
    return contactRepository.findContactByPatientId(id);
  }

  public Contact addContact(Contact contact){
    return contactRepository.save(contact);
  }

}
