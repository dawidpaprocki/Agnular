package application.controllers;

import application.entities.User;
import application.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return (List<User>) userRepository.findAll();
  }

  @GetMapping("/usersMap")
  public Map<String, String> getUsers2() {
    List<User> all = userRepository.findAll();
    Map<String, String> collect = all.stream().collect(Collectors.toMap(user -> user.getName(), user -> user.getEmail()));
    return collect;
  }

  @DeleteMapping("/delete/{id}")
  void deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
  }

  @PostMapping("/users")
  void addUser(@RequestBody User user) {
    userRepository.save(user);
  }
}
