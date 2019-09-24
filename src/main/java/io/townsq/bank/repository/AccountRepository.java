package io.townsq.bank.repository;

import static java.util.Arrays.asList;

import io.townsq.bank.domain.Account;
import java.util.List;
import java.util.stream.Collectors;

public class AccountRepository {
    private static List<Account> accounts = asList(
            new Account("00001-6", "Joao", 1235),
            new Account("00002-6", "Maria", 467235),
            new Account("00003-6", "Alberto", 98709123),
            new Account("00004-6", "Mariana", 345),
            new Account("00005-6", "Paloma", 5674),
            new Account("10001-6", "Reginaldo", 67634),
            new Account("10002-6", "Valdisnei", 437865)
            );

    public List<Account> getAll() {
        return accounts.stream().collect(Collectors.toList());
    }

    public Account get(String accountNumber) {
        return accounts
                .stream()
                .filter(a-> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public Account add(Account account) {
        accounts.add(account);
        return account;
    }
}
