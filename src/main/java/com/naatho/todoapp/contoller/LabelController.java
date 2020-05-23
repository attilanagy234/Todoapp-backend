package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/labels")
public class LabelController {
    // Dependency injection
    @Autowired
    private LabelRepository labelRepository;

    @PostMapping()
    public @ResponseBody
    String addNewLabel (@RequestBody Label label) {
        labelRepository.save(label);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Label> getLabelByID(@PathVariable String id) {
        return labelRepository.findById(id);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    void deleteLabelById(@PathVariable String id) {
        labelRepository.deleteById(id);
    }


}
