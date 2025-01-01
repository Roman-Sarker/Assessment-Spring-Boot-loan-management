package com.example.carloan.management.controller;


import com.example.carloan.management.model.Loan;
import com.example.carloan.management.model.LoanCustomerDTO;
import com.example.carloan.management.model.PaginatedResponse;
import com.example.carloan.management.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping //uri : localhost:8080/loans
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    @GetMapping //uri : localhost:8080/loans
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}") // uri : localhost:8080/loans/1
    public Loan getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    @PutMapping("/{id}") // uri : localhost:8080/loans/1
    public Loan updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        return loanService.updateLoan(id, loan);
    }

    @DeleteMapping("/{id}") // uri : localhost:8080/loans/1
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }

    @GetMapping("/search") // uri : localhost:8080/loans/search?loanId=&page=0&size=2 [Pagination]
    public PaginatedResponse<Loan> searchLoans(
            @RequestParam(required = false) Long loanId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Loan> loanPage = loanService.getLoansWithPagination(loanId, pageable);

        return new PaginatedResponse<>(
                loanPage.getContent(),
                loanPage.getTotalElements(),
                loanPage.getTotalPages()
        );
    }

    @GetMapping("/with-customers") // localhost:8080/loans/with-customers [Join Query]
    public ResponseEntity<List<LoanCustomerDTO>> getLoansWithCustomerDetails() {
        List<LoanCustomerDTO> loansWithCustomers = loanService.getLoansWithCustomerDetails();
        return ResponseEntity.ok(loansWithCustomers);
    }
}
