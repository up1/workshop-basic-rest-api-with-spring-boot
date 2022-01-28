package com.example.hello.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoTxController {

    @Autowired
    private DemoTxService demoTxService;

    @GetMapping("/tx")
    public String callWithTx() {
        demoTxService.callRepository();
        return "OK";
    }

}
