package com.tag;

import com.CustomException;
import com.scenario.Scenario;
import com.scenario.ScenarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TagController {


  private TagRepository tagRepository;

  public TagController(TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  @GetMapping("/tags")
  public List<Tag> getTags() {
    return (List<Tag>) tagRepository.findAll();
  }

  @GetMapping("/tag/{id}")
  public Tag getTag (@PathVariable Long id) {

    try {
      return tagRepository.findById(id).get();
    } catch (Exception e) {
      throw new CustomException("działa");
    }
  }


  @DeleteMapping("/tags/delete/{id}")
  void deleteTag(@PathVariable Long id) {
    tagRepository.deleteById(id);
  }

  @PostMapping("/addTag")
  void addTag(@RequestBody Tag tag) {
    tagRepository.save(tag);
  }
}
