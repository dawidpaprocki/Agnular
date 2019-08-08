package com.controllers;

import com.CustomException;
import com.entities.Privileges;
import com.entities.Scenario;
import com.repositories.PrivilegesRepository;
import com.repositories.ScenarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScenarioController {


  private ScenarioRepository scenarioRepository;

  public ScenarioController(ScenarioRepository scenarioRepository) {
    this.scenarioRepository = scenarioRepository;
  }

  @GetMapping("/scenario")
  public List<Scenario> getScenarios() {
    return (List<Scenario>) scenarioRepository.findAll();
  }

  @GetMapping("/scenario/{id}")
  public Scenario getScenarios(@PathVariable Long id) {

    try {
      return scenarioRepository.findById(id).get();
    } catch (Exception e) {
      throw new CustomException("działa");
    }
  }


  @DeleteMapping("/scenarios/delete/{id}")
  void deleteScenarios(@PathVariable Long id) {
    scenarioRepository.deleteById(id);
  }

  @PostMapping("/addScenarios")
  void addScenarios(@RequestBody Scenario scenario) {
    scenarioRepository.save(scenario);
  }
}
