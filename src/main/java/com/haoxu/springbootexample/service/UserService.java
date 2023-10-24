package com.haoxu.springbootexample.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.haoxu.springbootexample.model.User;
import com.haoxu.springbootexample.repository.UserRepository;

public class UserService{

    @Autowired
    private UserRepository userRepository;

    // return the user given id
    /**
     * Retrieves a user by their unique ID.
     *
     * @param userId the unique ID of the user to retrieve
     * @return the User object corresponding to the given ID, or null if no such user exists
     */
    public User getUserById(int userId){
       return userRepository.findByUserId(userId);
    }


    //save the user bu given username and password
    /**
     * Saves a new user with the given username and password.
     * @param userName the username of the new user
     * @param password the password of the new user
     * @return the newly created User object
     */
    public User saveUser(String userName, String password){
        User user = new User(userName, password);
        userRepository.save(user);
        return user;
    }
    
}
