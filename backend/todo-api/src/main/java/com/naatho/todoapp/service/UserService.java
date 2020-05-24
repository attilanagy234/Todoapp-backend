package com.naatho.todoapp.service;

import com.naatho.todoapp.entity.Role;
import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.entity.UserDetailsImpl;
import com.naatho.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("The address " + email + " is not valid");
        }
        user.getRoles().size();
        for(Role role : user.getRoles())
            role.getPrivileges().size();
        return new UserDetailsImpl(user);
    }
}
