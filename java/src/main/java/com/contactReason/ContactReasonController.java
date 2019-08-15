package com.contactReason;

import com.contact.Contact;
import com.contact.ContactRepository;
import com.exception.EntityNotFoundException;
import com.medicalCarer.MedicalCarer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactReasonController {
  private ContactRepository contactRepository;
  private ContactReasonRepository contactReasonRepository;

  public ContactReasonController(ContactRepository contactRepository, ContactReasonRepository contactReasonRepository){
    this.contactRepository = contactRepository;
    this.contactReasonRepository = contactReasonRepository;
  }

  @GetMapping("/contact-reason")
  public List<ContactReason> getContacts() {
    return contactReasonRepository.findAll();
  }

  @GetMapping("/contacts-reason/{id}")
  public List<ContactReason> getContactReasonForPatient(@PathVariable Long id) {
    List<Contact> contactByPatientId = contactRepository.findContactByPatientId(id);
    return contactByPatientId.stream().map(Contact::getContactReason).collect(Collectors.toList());
  }

  @GetMapping("/contact-reason/{id}")
  public ContactReason getContactReason(@PathVariable Long id) {
    return contactReasonRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("There is not Contact reason with id: " + id));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/contact-reason/add")
  void addContactReason(@RequestBody ContactReason contactReason) {
    contactReasonRepository.save(contactReason);
  }

  @PutMapping("/contact-reason/change")
  void changeMedicalCarer(@RequestBody ContactReason contactReason) {
    contactReasonRepository.save(contactReason);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("/contact-reason/delete/{id}")
  void deleteContactReason(@PathVariable Long id) {
    contactReasonRepository.deleteById(id);
  }
}
