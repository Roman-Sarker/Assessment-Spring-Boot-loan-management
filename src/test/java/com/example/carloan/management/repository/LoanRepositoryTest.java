package com.example.carloan.management.repository;

import com.example.carloan.management.model.Loan;
import com.example.carloan.management.model.LoanCustomerDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanRepository;

    @Test
    public void testFindAllLoans() {
        List<Loan> loans = loanRepository.findAll();
        Assertions.assertNotNull(loans);
        Assertions.assertFalse(loans.isEmpty());
    }

    @Test
    public void testFindAllLoansWithCustomerDetails() {
        List<LoanCustomerDTO> loanCustomerDTOS = loanRepository.findAllLoansWithCustomerDetails();
        Assertions.assertNotNull(loanCustomerDTOS);
        Assertions.assertFalse(loanCustomerDTOS.isEmpty());
    }
}
