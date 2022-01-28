package com.example.hello.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {

    @Autowired
    private RestTemplate restTemplate;

    private String baseUrl;

    @Autowired
    public UserGateway(@Value("${base_url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public UserResponse getUserById(int id) {
        // TODO
        UserResponse response = restTemplate.getForObject
                (this.baseUrl + "users/" + id
                        , UserResponse.class);
        return response;
    }

}
