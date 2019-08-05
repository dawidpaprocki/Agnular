package com.controllers;

import com.entities.User;
import com.entities.UserDTO;
import com.CustomException;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import com.repositories.UserRepository;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  private UserRepository userRepository;
  private DateConverter dateConverter;

  public UserController(UserRepository userRepository, DateConverter dateConverter) {
    this.userRepository = userRepository;
    this.dateConverter = dateConverter;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return (List<User>) userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public User getUser(@PathVariable Long id) {
    try {
      return userRepository.findById(id).get();
    } catch (Exception e) {
      throw new CustomException("działa");
    }
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
  void addUser(@RequestBody UserDTO user) {
    String startContactDateToConvert = user.getStartContact();
    User userToDb = new User();
    BeanUtils.copyProperties(user, userToDb, "StartContact");
    try {
      userToDb.setStartContact(
        dateConverter.convertDate(startContactDateToConvert)
      );
    } catch (ParseException e) {
      e.printStackTrace();
    }


    userRepository.save(userToDb);
  }
}
