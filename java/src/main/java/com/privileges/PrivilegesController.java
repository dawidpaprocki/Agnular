package com.privileges;

import com.CustomException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PrivilegesController {


  private PrivilegesRepository privilegesRepository;

  public PrivilegesController(PrivilegesRepository privilegesRepository) {
    this.privilegesRepository = privilegesRepository;
  }

  @GetMapping("/Privileges")
  public List<Privileges> getPrivileges() {
    return (List<Privileges>) privilegesRepository.findAll();
  }

  @GetMapping("/privileges/{id}")
  public Privileges getPrivileges(@PathVariable Long id) {

    try {
      return privilegesRepository.findById(id).get();
    } catch (Exception e) {
      throw new CustomException("działa");
    }
  }


  @DeleteMapping("/privileges/delete/{id}")
  void deletePrivileges(@PathVariable Long id) {
    privilegesRepository.deleteById(id);
  }

  @PostMapping("/addPrivileges")
  void addPrivileges(@RequestBody Privileges privileges) {
    privilegesRepository.save(privileges);
  }
}
