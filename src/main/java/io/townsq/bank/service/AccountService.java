package io.townsq.bank.service;

import io.townsq.bank.domain.Account;
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
}
