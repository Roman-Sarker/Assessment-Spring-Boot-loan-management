package com.example.carloan.management.controller;

import com.example.carloan.management.model.CustomerInstallmentDTO;
import com.example.carloan.management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/installmentHistory") // uri : localhost:8080/customer/installmentHistory
    public List<CustomerInstallmentDTO> getAllLoans() {
        return customerService.customerAllInstallmentStatus();
    }
}
