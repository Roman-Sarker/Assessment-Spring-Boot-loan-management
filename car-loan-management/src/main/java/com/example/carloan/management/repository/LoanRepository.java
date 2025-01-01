package com.example.carloan.management.repository;

import com.example.carloan.management.model.Loan;
import com.example.carloan.management.model.LoanCustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Page<Loan> findById(Long loanId, Pageable pageable);
    @Query("SELECT new com.example.carloan.management.model.LoanCustomerDTO(l.id, l.amount, l.tenure, l.interestRate, c.name, c.email) " +
            "FROM Loan l JOIN Customer c ON l.customerId = c.id")
    List<LoanCustomerDTO> findAllLoansWithCustomerDetails();
}
