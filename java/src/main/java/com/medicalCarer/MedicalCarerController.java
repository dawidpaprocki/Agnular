package com.medicalCarer;

import com.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalCarerController {

  private MedicalCarerRepository medicalCarerRepository;

  public MedicalCarerController(MedicalCarerRepository medicalCarerRepository) {
    this.medicalCarerRepository = medicalCarerRepository;
  }

  @GetMapping("/medical-carers")
  public List<MedicalCarer> getMedicalCarers() {
    return (List<MedicalCarer>) medicalCarerRepository.findAll();
  }

  @GetMapping("/medical-carer/{id}")
  public MedicalCarer getMedicalCarer(@PathVariable Long id) {
    return medicalCarerRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("There is not Medical Carer with id: " + id));
  }

  @DeleteMapping("/medical-carer/delete/{id}")
  void deleteMedicalCarer(@PathVariable Long id) {
    medicalCarerRepository.deleteById(id);
  }

  @PostMapping("/medical-carer/add")
  void addMedicalCarer(@RequestBody MedicalCarer medicalCarer) {
    medicalCarerRepository.save(medicalCarer);
  }

  @PutMapping("/medical-carer/change")
  void changeMedicalCarer(@RequestBody MedicalCarer medicalCarer) {
    medicalCarerRepository.save(medicalCarer);
  }
}
