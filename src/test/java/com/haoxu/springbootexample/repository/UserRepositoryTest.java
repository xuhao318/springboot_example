package com.haoxu.springbootexample.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.haoxu.springbootexample.model.User;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserName() {
        // given
        User user = new User("testUserName", "password");
        userRepository.save(user);

        // when
        User foundUser = userRepository.findByUserName("testUserName");

        // then
        assertThat(foundUser).isEqualTo(user);
    }

    @Test
    public void testFindPasswordByUserName() {
        // given
        User user = new User("testUserName", "password");
        userRepository.save(user);

        // when
        User foundUser = userRepository.findPasswordByUserName("testUserName");

        // then
        assertThat(foundUser).isEqualTo(user);
    }

    @Test
    public void testFindByUserId() {
        // given
        User user = new User("testUserName", "password");
        userRepository.save(user);

        // when
        User foundUser = userRepository.findByUserId(user.getUserId());

        // then
        assertThat(foundUser).isEqualTo(user);
    }
}