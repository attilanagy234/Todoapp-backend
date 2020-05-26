package com.naatho.todoapp.service;

import com.naatho.todoapp.contoller.MainController;
import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.repository.LabelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {

    @Autowired
    LabelRepository labelRepository;

    Logger logger = LoggerFactory.getLogger(LabelService.class);

    public void save(Label label) {
        logger.debug("Saving label {}", label);
        labelRepository.save(label);
    }

    public List<Label> findAll() {
        logger.debug("Querying all labels");
        return labelRepository.findAll();
    }

    public Optional<Label> findById(String id) {
        logger.debug("Searching for label by id {}", id);
        return labelRepository.findById(id);
    }

    public void deleteById(String id) {
        logger.debug("Attempting to delete label with id {}", id);
        labelRepository.deleteById(id);
    }
}
