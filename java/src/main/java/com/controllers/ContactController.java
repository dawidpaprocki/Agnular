package com.controllers;

import com.entities.Contact;
import com.repositories.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {
  private ContactRepository contactRepository;

  public ContactController(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  @GetMapping("/contacts")
  public List<Contact> getContacts() {
    return contactRepository.findAll();
  }

  @GetMapping("/contacts/{id}")
  public List<Contact> getContactsForPatient(@PathVariable Long id) {
    return contactRepository.findContactByPatientId(id);
  }

  @PostMapping("/addcontact")
  void addContact(@RequestBody Contact contact) {
    contactRepository.save(contact);
  }

  @DeleteMapping("/contacts/{id}")
  void addContact(@PathVariable Long id) {
    contactRepository.deleteById(id);
  }
}
