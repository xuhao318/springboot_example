package com.haoxu.springbootexample.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    
    @Test
    public void testUserId() {
        String userName = "testUserName";
        String password = "password";
        User user = new User(userName, password);
        user.setUserId(123);
        assertEquals(123, user.getUserId());
    }
    
}