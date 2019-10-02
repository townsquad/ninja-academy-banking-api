package io.townsq.bank.service;

import io.townsq.bank.domain.Account;
import io.townsq.bank.domain.TransferRequest;
import io.townsq.bank.repository.AccountRepository;
import java.util.List;

public class AccountService {
    private AccountRepository repository = new AccountRepository();

    public Account get(String accountNumber) {
        Account account = repository.get(accountNumber);

        if (account == null) {
            throw new RuntimeException("Account not found");
        }

        return account;
    }

    public List<Account> getAll() {
        return repository.getAll();
    }

    public void transfer(TransferRequest request) {
        Account originAccount = get(request.getOriginAccount());
        Account destinationAccount = get(request.getDestinationAccount());

        if (originAccount == null || !originAccount.has(request.getValue()) || originAccount.getOwner().equals(request.getOriginOwner())) {
            throw new RuntimeException("origin information is invalid.");
        }

        if (destinationAccount == null || destinationAccount.getOwner().equals(request.getOriginOwner())) {
            throw new RuntimeException("destination information is invalid.");
        }

        originAccount.withdraw(request.getValue());
        destinationAccount.deposit(request.getValue());
    }
}
