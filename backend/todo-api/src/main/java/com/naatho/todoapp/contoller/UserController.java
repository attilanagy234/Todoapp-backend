package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.repository.UserRepository;
import com.naatho.todoapp.service.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path="/users")
public class UserController {

    // Dependency injection
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    @PostMapping()
    public @ResponseBody
    ResponseEntity<User> addNewUser (@Valid @RequestBody User newUser) {
        userService.save(newUser);
        logger.info("User saved: {}", newUser.getName());
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    @GetMapping()
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    @GetMapping(path="/{id}")
    public @ResponseBody
    ResponseEntity<User> getUserByID(@PathVariable Integer id) {
        Optional<User> foundUser = userService.findById(id);

        if (foundUser == null) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(foundUser.get());
        }
    }

    @PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    @DeleteMapping(path="/{id}")
    public @ResponseBody
    ResponseEntity<User> deleteUserById(@PathVariable Integer id) {
        Optional<User> foundUser = userService.findById(id);

        if (foundUser == null) {
            return ResponseEntity.notFound().build();

        } else {
            userService.deleteById(id);
            return ResponseEntity.ok(foundUser.get());
        }
    }
}
