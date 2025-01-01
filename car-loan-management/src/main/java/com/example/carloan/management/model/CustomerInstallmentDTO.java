package com.example.carloan.management.model;

public class CustomerInstallmentDTO {
    private int customerId;
    private String customerName;
    private String installmentRemain;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInstallmentRemain() {
        return installmentRemain;
    }

    public void setInstallmentRemain(String installmentRemain) {
        this.installmentRemain = installmentRemain;
    }
}
