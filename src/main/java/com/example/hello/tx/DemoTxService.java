package com.example.hello.tx;

import com.example.hello.User;
import com.example.hello.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoTxService {

    @Autowired
    private UserRepository userRepository;

    public void callRepository() {
        step1();
        step2();
        processLongRunning();
    }

    public void processLongRunning() {
    }

    @Transactional
    public void step1(){
        User user1 = new User(1, "user 1");
        User user2 = new User(2, "user 2");

        // Transaction 1
        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Transactional
    public void step2() {
        User user3 = new User(3, "user 3");
        // Transaction 2
        userRepository.save(user3);
    }

}
