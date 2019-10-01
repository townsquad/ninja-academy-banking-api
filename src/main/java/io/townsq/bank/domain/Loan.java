package io.townsq.bank.domain;

public class Loan {

    private String id;
    private String accountNumber;
    private double amount;
    private Status status;

    public Loan(String id, String accountNumber, double amount, Status status) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
