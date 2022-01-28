package com.example.hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void concatData() {
        // Arrange
        User user = new User();
        user.setName("testing");
        when(userRepository.findByName("testing")).thenReturn(Optional.of(user));
        // Act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        String result = userService.concatData("testing");
        // Assert
        assertEquals("Hello testing", result);
    }
}