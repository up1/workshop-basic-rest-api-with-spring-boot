package com.example.hello;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByName_with_success() {
        // Arrange
        User user = new User();
        user.setId(1000);
        user.setName("testing");
        userRepository.save(user);
        // Act
        Optional<User> result = userRepository.findByName("testing");
        // Assert
        assertTrue(result.isPresent());
    }

    @Test
    void findByName_with_failure() {
        // Act
        Optional<User> result = userRepository.findByName("testing");
        // Assert
        assertFalse(result.isPresent());
    }
}