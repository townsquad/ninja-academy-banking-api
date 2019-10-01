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
        loans.add(loan);
        return loan;
    }
}
