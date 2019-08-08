package com.controllers;

import com.CustomException;
import com.entities.MedicalCarer;
import com.entities.User;
import com.repositories.MedicalCarerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalCarerController {


  private MedicalCarerRepository medicalCarerRepository;

  public MedicalCarerController(MedicalCarerRepository medicalCarerRepository) {
    this.medicalCarerRepository = medicalCarerRepository;
  }

  @GetMapping("/MedicalCarers")
  public List<MedicalCarer> getMedicalCarers() {
    return (List<MedicalCarer>) medicalCarerRepository.findAll();
  }

  @GetMapping("/medicalCarers/{id}")
  public MedicalCarer getMedicalCarer(@PathVariable Long id) {

    try {
      return medicalCarerRepository.findById(id).get();
    } catch (Exception e) {
      throw new CustomException("działa");
    }
  }


  @DeleteMapping("/medicalCarer/delete/{id}")
  void deleteMedicalCarer(@PathVariable Long id) {
    medicalCarerRepository.deleteById(id);
  }

  @PostMapping("/addMedicalCarer")
  void addMedicalCarer(@RequestBody MedicalCarer medicalCarer) {
    medicalCarerRepository.save(medicalCarer);
  }
}
