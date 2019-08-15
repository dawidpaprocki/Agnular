package com.action;

import com.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ActionController {
  private ActionRepository actionRepository;

  public ActionController(ActionRepository actionRepository) {
    this.actionRepository = actionRepository;
  }

  @GetMapping("/actions")
  public List<Action> getActions() {
    return actionRepository.findAll();
  }

  @GetMapping("/action/{id}")
  public Action getAction(@PathVariable Long id) {
    return actionRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("There is not Action with id: " + id));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/action/add")
  public void addAction(@RequestBody Action action) {
    actionRepository.save(action);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("/action/{id}")
  public void deleteAction(@PathVariable Long id) {
    actionRepository.deleteById(id);
  }
}
