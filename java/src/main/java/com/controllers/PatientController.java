package com.controllers;

import com.CustomException;
import com.entities.Patient;
import com.entities.PatientDTO;
import com.entities.UserDTO;
import com.repositories.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

  private PatientRepository patientRepository;
  private DateConverter dateConverter;

  public PatientController(PatientRepository patientRepository, DateConverter dateConverter) {
    this.patientRepository = patientRepository;
    this.dateConverter = dateConverter;
  }

  @GetMapping("/patients")
  public List<Patient> getUsers() {
    return (List<Patient>) patientRepository.findAll();
  }

  @GetMapping("/patients/{id}")
  public Patient getUser(@PathVariable Long id) {
    try {
      return patientRepository.findById(id).get();
    } catch (Exception e) {
      throw new CustomException("działa");
    }
  }


  @DeleteMapping("patient/delete/{id}")
  void deleteUser(@PathVariable Long id) {
    patientRepository.deleteById(id);
  }

  @PostMapping("/patients")
  void addUser(@RequestBody PatientDTO patientDTO) {
    String startContactDateToConvert = patientDTO.getStartContact();
    Patient patientToDb = new Patient();
    BeanUtils.copyProperties(patientDTO, patientToDb, "StartContact");
    try {
      patientToDb.setStartContact(
        dateConverter.convertDate(startContactDateToConvert)
      );
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
