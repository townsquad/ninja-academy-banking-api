package io.townsq.bank.domain;

public class Loan {
    private String accountNumber;
    private double amount;
    private Status status;

    public Loan(String accountNumber, double amount, Status status) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
