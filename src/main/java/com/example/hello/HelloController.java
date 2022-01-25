package com.example.hello;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello/{name}")
    public HelloResponse sayHi(@PathVariable String name) {
        return new HelloResponse(userService.concatData(name));
    }

}
