package io.townsq.bank.domain;

public class Loan {

    public Loan(String accountNumber, double amount, Status status) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.status = status;
    }

    private String accountNumber;
    private double amount;
    private Status status;
}
