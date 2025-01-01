package com.example.carloan.management.service;

import com.example.carloan.management.model.CustomerInstallmentDTO;
import java.util.List;

public interface CustomerService {
     List<CustomerInstallmentDTO> customerAllInstallmentStatus();
}
