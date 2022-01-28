package com.example.hello.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Service2 {

    @Autowired
    private Service3 service3;

    @Transactional
    public void doSth() {
        service3.doSth();
    }

}
