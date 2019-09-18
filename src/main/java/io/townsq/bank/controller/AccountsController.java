package io.townsq.bank.controller;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import io.townsq.bank.domain.Account;
import io.townsq.bank.domain.WithdrawRequest;
import io.townsq.bank.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountsController {

    private AccountRepository repository = new AccountRepository();

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> get(@PathVariable String accountNumber) {
        Account account = repository.get(accountNumber);

        if(account == null) {
            return noContent().build();
        }

        return ok(account);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable String accountNumber, @RequestBody WithdrawRequest withdrawRequest) {
        Account account = repository.get(accountNumber);

        if(account == null || !account.getOwner().equals(withdrawRequest.getRequester()) || !account.has(withdrawRequest.getValue())) {
            return badRequest().build();
        }

        account.withdraw(withdrawRequest.getValue());

        return ok(account);
    }

}
