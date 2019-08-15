package com.medicalFacility;

import com.CustomException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalFacilityController {

  private MedicalFacilityRepository medicalFacilityRepository;

  public MedicalFacilityController(MedicalFacilityRepository medicalFacilityRepository) {
    this.medicalFacilityRepository = medicalFacilityRepository;
  }

  @GetMapping("/medicalFacilities")
  public List<MedicalFacility> getMedicalFacility() {
    return (List<MedicalFacility>) medicalFacilityRepository.findAll();
  }

  @GetMapping("/medicalFacility/{id}")
  public MedicalFacility getMedicalFacility(@PathVariable Long id) {

    try {
      return medicalFacilityRepository.findById(id).get();
    } catch (Exception e) {
      throw new CustomException("działa");
    }
  }


  @DeleteMapping("/medicalFacilities/delete/{id}")
  void deleteMedicalFacility(@PathVariable Long id) {
    medicalFacilityRepository.deleteById(id);
  }

  @PostMapping("/addMedicalFacility")
  void addMedicalFacility(@RequestBody  MedicalFacility medicalFacility) {
    medicalFacilityRepository.save(medicalFacility);
  }
}
