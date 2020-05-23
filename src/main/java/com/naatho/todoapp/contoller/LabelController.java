package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.repository.LabelRepository;
import com.naatho.todoapp.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/labels")
public class LabelController {

    // Dependency injection
    @Autowired
    private LabelService labelService;

    @PostMapping()
    public @ResponseBody
    String addNewLabel (@RequestBody Label label) {
        labelService.save(label);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<Label> getAllLabels() {
        return labelService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Label> getLabelByID(@PathVariable String id) {
        return labelService.findById(id);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    void deleteLabelById(@PathVariable String id) {
        labelService.deleteById(id);
    }


}
