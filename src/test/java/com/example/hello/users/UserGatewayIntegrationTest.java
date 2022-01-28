package com.example.hello.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserGatewayIntegrationTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    void getUserById() {
        // Act
        UserResponse result = userGateway.getUserById(1);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("Leanne Graham", result.getName());
    }
}