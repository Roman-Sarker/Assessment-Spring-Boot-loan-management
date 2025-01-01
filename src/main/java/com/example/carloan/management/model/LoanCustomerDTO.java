package com.example.carloan.management.model;

public class LoanCustomerDTO {
    private Long loanId;
    private Double amount;
    private Integer tenure;
    private Double interestRate;
    private String customerName;
    private String customerEmail;

    // Constructor
    public LoanCustomerDTO(Long loanId, Double amount, Integer tenure, Double interestRate, String customerName, String customerEmail) {
        this.loanId = loanId;
        this.amount = amount;
        this.tenure = tenure;
        this.interestRate = interestRate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    // Getters and Setters
    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
