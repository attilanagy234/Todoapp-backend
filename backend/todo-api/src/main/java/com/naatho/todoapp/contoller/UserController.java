package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.repository.UserRepository;
import com.naatho.todoapp.service.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/users")
public class UserController {

    // Dependency injection
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping()
    public @ResponseBody
    String addNewUser (@RequestBody User newUser) {

        userService.save(newUser);

        logger.info("User saved: {}", newUser.getName());
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<User> getUserByID(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    void deleteUserById(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
