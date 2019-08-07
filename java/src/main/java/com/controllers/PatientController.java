package com.controllers;

import com.CustomException;
import com.entities.Patient;
import com.entities.PatientDTO;
import com.repositories.PatientRepository;
import com.tools.PropertiesReader;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

  private PatientRepository patientRepository;
  private DateConverter dateConverter;
  private PropertiesReader propertiesReader;

  public PatientController(PatientRepository patientRepository, DateConverter dateConverter, PropertiesReader propertiesReader) {
    this.patientRepository = patientRepository;
    this.dateConverter = dateConverter;
    this.propertiesReader = propertiesReader;
  }

  @GetMapping("/patients")
  public List<Patient> getPatients() {
    return (List<Patient>) patientRepository.findAll();
  }

  @GetMapping("/patients/{id}")
  public Patient getPatient(@PathVariable Long id) {
    return patientRepository.findById(id).orElseThrow(() ->
      new CustomException(propertiesReader.getFromProperties("NoPatient")));
  }


  @DeleteMapping("patients/delete/{id}")
  void deletePatient(@PathVariable Long id) {
    patientRepository.deleteById(id);
  }

  @PostMapping("/patients")
  void addPatient(@RequestBody PatientDTO patientDTO) {
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
