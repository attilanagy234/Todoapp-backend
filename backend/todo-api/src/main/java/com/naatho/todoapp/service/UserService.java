package com.naatho.todoapp.service;

import com.naatho.todoapp.contoller.MainController;
import com.naatho.todoapp.entity.Role;
import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.entity.UserDetailsImpl;
import com.naatho.todoapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(MainController.class);


    public void save(User user) {
        logger.debug("Saving user {}", user);
        userRepository.save(user);
    }

  //  @PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    public List<User> findAll() {
        logger.debug("Querying all users");
        return userRepository.findAll();
    }

    //@PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    public Optional<User> findById(Integer id) {
        logger.debug("Searching for user by id {} ", id);
        return userRepository.findById(id);
    }

    //@PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    public void deleteById(Integer id) {
        logger.debug("Attempting to delete user by id {}", id);
        userRepository.deleteById(id);
    }

    public User findByEmail(String email) {
        logger.debug("Searching for user by email {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.debug("Loading user by email...");
        User user = this.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("The address " + email + " is not valid");
        }
        user.getRoles().size();
        for(Role role : user.getRoles()) {
            logger.trace("Role of user {} is {}", user.getName(), role.getName());
            role.getPrivileges().size();
        }
        return new UserDetailsImpl(user);
    }
}
