package io.townsq.bank.service;

import io.townsq.bank.domain.Account;
import io.townsq.bank.repository.AccountRepository;
import java.util.List;

public class AccountService {
    private AccountRepository repository = new AccountRepository();

    public Account get(String account) {
        return  repository.get(account);
    }

    public List<Account > getAll() {
        return  repository.getAll();
    }
}
