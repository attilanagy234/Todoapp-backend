package com.naatho.todoapp;


import org.springframework.data.repository.CrudRepository;

import com.naatho.todoapp.User;


public interface UserRepository extends CrudRepository<User, Integer> {

}