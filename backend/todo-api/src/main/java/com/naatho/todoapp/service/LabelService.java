package com.naatho.todoapp.service;

import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {

    @Autowired
    LabelRepository labelRepository;

    public void save(Label label) {
        labelRepository.save(label);
    }

    public List<Label> findAll() {
        return labelRepository.findAll();
    }

    public Optional<Label> findById(String id) {
        return labelRepository.findById(id);
    }

    public void deleteById(String id) {
        labelRepository.deleteById(id);
    }
}
