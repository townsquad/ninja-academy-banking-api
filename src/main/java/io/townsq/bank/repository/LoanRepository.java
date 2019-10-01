package io.townsq.bank.repository;

import io.townsq.bank.domain.Loan;
import io.townsq.bank.domain.Status;
import java.util.ArrayList;
import java.util.List;

public class LoanRepository {
    private static List<Loan> loans;

    public LoanRepository() {
        loans = new ArrayList<>();
        loans.add(new Loan("123", "00001-6", 1212, Status.APPROVED));
        loans.add(new Loan("345", "00002-6", 10000, Status.WAITING));
        loans.add(new Loan("678", "00003-6", 10000000, Status.DENIED));
    }

    public List<Loan> getAll() {
        return loans;
    }

    public Loan save(Loan loan) {
        if (loan.getId() != null) {
            edit(loan);
            return loan;
        }
        loan.setId(String.valueOf(Math.random()));
        loans.add(loan);
        return loan;
    }

    public Loan getById(String id) {
        for (Loan loan : loans) {
            if (loan.getId().equals(id)) {
                return loan;
            }
        }

        return null;
    }

    public void edit(Loan loan) {
        Loan loanToBeEdited = getById(loan.getId());
        loanToBeEdited.setStatus(loan.getStatus());
        loanToBeEdited.setAccountNumber(loan.getAccountNumber());
        loanToBeEdited.setAmount(loan.getAmount());
    }
}
