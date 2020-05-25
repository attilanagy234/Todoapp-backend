package com.naatho.todoapp.contoller;

import com.naatho.todoapp.entity.Role;
import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.service.RoleService;
import com.naatho.todoapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.Arrays;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @PostMapping(path="/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        logger.info("Registering user...");
        User foundUser = userService.findByEmail(user.getEmail());

        if (foundUser != null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        User newUser = new User(
                user.getName(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword())

        );
        newUser.setRoles(Arrays.asList(roleService.findByName(Role.USER_ROLE)));
        userService.save(newUser);
        ResponseEntity<User> response = ResponseEntity.ok(newUser);
        return response;
    }

}