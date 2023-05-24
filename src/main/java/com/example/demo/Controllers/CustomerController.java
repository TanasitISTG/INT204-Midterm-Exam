package com.example.demo.Controllers;

import com.example.demo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/64130500034/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/init")
    public void init() {
        customerService.init();
    }
}
