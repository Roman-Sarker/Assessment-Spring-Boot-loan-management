package com.example.carloan.management.service;

import com.example.carloan.management.model.Loan;
import com.example.carloan.management.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoanServiceTest {
    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanServiceImpl loanService; // Used the implementation class.

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks.
    }

    @Test
    void testGetAllLoans() {
        // Mock behavior
        when(loanRepository.findAll()).thenReturn(List.of(
                new Loan(1L, 5000.0, 24, 5.5, 1L),
                new Loan(2L, 7000.0, 36, 4.5, 2L)
        ));

        // Call service
        List<Loan> loans = loanService.getAllLoans();

        // Assertions
        assertNotNull(loans);
        assertEquals(2, loans.size());
        verify(loanRepository, times(1)).findAll();
    }
}
