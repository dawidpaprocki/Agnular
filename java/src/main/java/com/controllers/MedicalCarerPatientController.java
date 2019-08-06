package com.controllers;

import com.CustomException;
import com.entities.MedicalCarer;
import com.entities.MedicalCarerPatient;
import com.entities.User;
import com.repositories.MedicalCarerPatientRepository;
import com.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalCarerPatientController {

  private MedicalCarerPatientRepository medicalCarerPatientRepository;


  public MedicalCarerPatientController(MedicalCarerPatientRepository medicalCarerPatientRepository) {
    this.medicalCarerPatientRepository = medicalCarerPatientRepository;
  }

  @GetMapping("/medicalCarerPatient")
  public List<MedicalCarerPatient> getMedicalCaredPatient() {
    return (List<MedicalCarerPatient>) medicalCarerPatientRepository.findAll();
  }

  @GetMapping("/medicalCarerPatient/{id}")
  public MedicalCarerPatient getMedicalCarerPatient(@PathVariable Long id) {
    try {
      return medicalCarerPatientRepository.findById(id).get();
    } catch (Exception e) {
      throw new CustomException("działa");
    }
  }

  @DeleteMapping("/medicalCarerPatient/delete/{id}")
  void deleteUser(@PathVariable Long id) {
    medicalCarerPatientRepository.deleteById(id);
  }

  @PostMapping("/addmedicalCarerPatient")
  void addUser(@RequestBody MedicalCarerPatient medicalCarerPatient) {medicalCarerPatientRepository.save(medicalCarerPatient);
  }
}
