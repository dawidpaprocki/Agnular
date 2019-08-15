package com.medicalCarerPatient;

import com.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalCarerPatientController {

  private MedicalCarerPatientRepository medicalCarerPatientRepository;


  public MedicalCarerPatientController(MedicalCarerPatientRepository medicalCarerPatientRepository) {
    this.medicalCarerPatientRepository = medicalCarerPatientRepository;
  }

  @GetMapping("/medical-carer-patient")
  public List<MedicalCarerPatient> getMedicalCaredPatient() {
    return medicalCarerPatientRepository.findAll();
  }

  @GetMapping("/medical-carer-patient/{id}")
  public MedicalCarerPatient getMedicalCarerPatient(@PathVariable Long id) {
    return medicalCarerPatientRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("There is not Medical Carer Patient with id: " + id));
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("/medical-carer-patient/delete/{id}")
  void deleteMedicalCarerPatient(@PathVariable Long id) {
    medicalCarerPatientRepository.deleteById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/medical-carer-patient/add")
  void addMedicalCarerPatient(@RequestBody MedicalCarerPatient medicalCarerPatient) {
    medicalCarerPatientRepository.save(medicalCarerPatient);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PutMapping("/medical-carer-patient/change")
  void changeMedicalCarerPatient(@RequestBody MedicalCarerPatient medicalCarerPatient) {
    medicalCarerPatientRepository.save(medicalCarerPatient);
  }
}
