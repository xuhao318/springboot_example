package com.haoxu.springbootexample.repository;

import org.springframework.data.repository.CrudRepository;

import com.haoxu.springbootexample.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserName(String userName);

    // retrieve password by username
    User findPasswordByUserName(String userName);

    //return the user by id
    User findByUserId(int userId);
    
}
