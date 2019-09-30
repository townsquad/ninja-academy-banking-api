package io.townsq.bank.service;

import io.townsq.bank.domain.Loan;
import io.townsq.bank.repository.LoanRepository;
import java.util.List;

public class LoanService {
    private LoanRepository repository = new LoanRepository();

    public List<Loan> getAll() {
        return repository.getAll();
    }

}
