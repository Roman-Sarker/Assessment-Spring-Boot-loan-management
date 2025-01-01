package com.example.carloan.management.service;

import com.example.carloan.management.model.CustomerInstallmentDTO;
import com.example.carloan.management.util.CustomerInstallmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerInstallmentClient openFeignClient;

    public CustomerServiceImpl(CustomerInstallmentClient customerInstallmentClient) {
        this.openFeignClient = customerInstallmentClient;
    }

    @Override
    public List<CustomerInstallmentDTO> customerAllInstallmentStatus() {
        return openFeignClient.getCustomerInstallments();
    }
}