package io.townsq.bank.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import io.townsq.bank.domain.Account;
import io.townsq.bank.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/Accounts")
public class AccountsController {

    private final AccountRepository repo = new AccountRepository();

    @GetMapping
    public Account get() {

        return new Account("123", "joao", 100);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> get(@PathVariable String accountNumber) {
        Account account = repo.get(accountNumber);
        if (account == null) {
            return notFound().build();
        }

        return ok(account);
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable String accountNumber, @RequestBody DepositRequest request) {
        Account account = repo.get(accountNumber);

        if (account == null) {
            return notFound().build();
        }

        account.setAvailable(account.getAvailable() + request.value);

        return ok(account);
    }
}

class DepositRequest {
    public double value;
}
