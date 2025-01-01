package com.example.carloan.management.service;

import com.example.carloan.management.repository.LoanRepository;
import com.example.carloan.management.model.Loan;
import com.example.carloan.management.model.LoanCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    @Override
    public Loan updateLoan(Long id, Loan loan) {
        Loan existingLoan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found"));
        existingLoan.setAmount(loan.getAmount());
        existingLoan.setTenure(loan.getTenure());
        existingLoan.setInterestRate(loan.getInterestRate());
        existingLoan.setCustomerId(loan.getCustomerId());
        return loanRepository.save(existingLoan);
    }

    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public Page<Loan> getLoansWithPagination(Long loanId, Pageable pageable) {
        if (loanId != null) {
            return loanRepository.findById(loanId, pageable);
        }
        return loanRepository.findAll(pageable);
    }
    @Override
    public List<LoanCustomerDTO> getLoansWithCustomerDetails() {
        return loanRepository.findAllLoansWithCustomerDetails();
    }
}
