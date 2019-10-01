package io.townsq.bank.service;

import io.townsq.bank.domain.Loan;
import io.townsq.bank.domain.Status;
import io.townsq.bank.repository.LoanRepository;
import java.util.List;

public class LoanService {
    private LoanRepository repository = new LoanRepository();

    public List<Loan> getAll() {
        return repository.getAll();
    }

    public Loan create(Loan loan) {
        loan.setStatus(Status.WAITING);
        return repository.save(loan);
    }

    public Loan accept(String loanId) {
        Loan loan = repository.getById(loanId);

        if (loan != null) {
            loan.setStatus(Status.APPROVED);
            repository.save(loan);
        } else {
            throw new RuntimeException();
        }

        return loan;
    }
}
