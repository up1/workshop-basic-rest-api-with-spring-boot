package com.example.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("ส่ง username = testing แล้วจะต้องได้รับข้อความ Hello testing")
    void case01() {
        // Arrange
        User user = new User();
        user.setName("testing");
        when(userRepository.findByName("testing")).thenReturn(Optional.of(user));
        // Act
        HelloResponse result = testRestTemplate.getForObject("/hello/testing",
                HelloResponse.class);
        // Assert, verify
        assertEquals("Hello testing", result.getMessage());
    }

    @Test
    @DisplayName("ส่ง username = other แล้วจะต้องได้รับข้อความ User other not" +
            " found")
    void case02() {
        // Act
        HelloResponse result = testRestTemplate.getForObject("/hello/other",
                HelloResponse.class);
        // Assert, verify
        assertEquals("User=other not found", result.getMessage());
    }
}