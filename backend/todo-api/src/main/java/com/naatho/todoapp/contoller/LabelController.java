package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.repository.LabelRepository;
import com.naatho.todoapp.service.LabelService;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path="/labels")
public class LabelController {

    // Dependency injection
    @Autowired
    private LabelService labelService;

    @PostMapping()
    public @ResponseBody
    ResponseEntity<Label> addNewLabel (@Valid @RequestBody Label label) {
        labelService.save(label);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public @ResponseBody Iterable<Label> getAllLabels() {
        return labelService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    ResponseEntity<Label> getLabelByID(@PathVariable String id) {
        Optional<Label> foundLabel = labelService.findById(id);
        if (foundLabel.isEmpty()) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(foundLabel.get());
        }
    }
    @DeleteMapping(path="/{id}")
    public @ResponseBody
    ResponseEntity<Label> deleteLabelById(@PathVariable String id) {
        Optional<Label> foundLabel = labelService.findById(id);
        if (foundLabel == null) {
            return ResponseEntity.notFound().build();
        } else {
            labelService.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

}
