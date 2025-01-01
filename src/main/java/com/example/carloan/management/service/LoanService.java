package com.example.carloan.management.service;

import com.example.carloan.management.model.Loan;
import com.example.carloan.management.model.LoanCustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoanService {
    Loan createLoan(Loan loan);
    List<Loan> getAllLoans();
    Loan getLoanById(Long id);
    Loan updateLoan(Long id, Loan loan);
    void deleteLoan(Long id);
    Page<Loan> getLoansWithPagination(Long Loan, Pageable pageable);
    List<LoanCustomerDTO> getLoansWithCustomerDetails();

}
