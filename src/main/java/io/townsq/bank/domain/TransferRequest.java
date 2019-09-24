package io.townsq.bank.domain;

public class TransferRequest {
    private String originAccount;
    private String destinationAccount;

    private String originOwner;
    private String destinationOwner;

    private double value;

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getOriginOwner() {
        return originOwner;
    }

    public void setOriginOwner(String originOwner) {
        this.originOwner = originOwner;
    }

    public String getDestinationOwner() {
        return destinationOwner;
    }

    public void setDestinationOwner(String destinationOwner) {
        this.destinationOwner = destinationOwner;
    }
}
