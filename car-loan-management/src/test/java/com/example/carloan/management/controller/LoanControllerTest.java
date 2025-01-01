package com.example.carloan.management.controller;

import com.example.carloan.management.model.Loan;
import com.example.carloan.management.service.LoanService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(LoanController.class)
@ExtendWith(SpringExtension.class)
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanService loanService; // Use @MockBean only here for Spring components.

    @Test
    public void testGetLoans() throws Exception {
        Loan loan = new Loan(1L, 10000.0, 12, 5.0, 1L);
        Mockito.when(loanService.getAllLoans()).thenReturn(List.of(loan));

        mockMvc.perform(MockMvcRequestBuilders.get("/loans"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].amount").value(10000.0));
    }
}
