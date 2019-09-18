package io.townsq.bank.domain;

public class Account {
    private String accountNumber;
    private String owner;
    private double available;


    public Account(String accountNumber, String owner, double available) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.available = available;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public boolean has(double value) {
        return getAvailable() >= value;
    }

    public void withdraw(double value) {
        setAvailable(getAvailable() - value);
    }
}
