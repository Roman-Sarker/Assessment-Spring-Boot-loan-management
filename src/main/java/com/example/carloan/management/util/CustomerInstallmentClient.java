package com.example.carloan.management.util;

import com.example.carloan.management.model.CustomerInstallmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "CustomerInstallmentClient", url = "https://dummyjson.com")
public interface CustomerInstallmentClient {
    @GetMapping("/c/e5f5-0745-49e8-acf5")
    List<CustomerInstallmentDTO> getCustomerInstallments();
}
