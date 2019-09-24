package io.townsq.bank.controller;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import io.townsq.bank.domain.Account;
import io.townsq.bank.domain.DepositRequest;
import io.townsq.bank.domain.TransferRequest;
import io.townsq.bank.domain.WithdrawRequest;
import io.townsq.bank.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
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

        if (account == null) {
            return noContent().build();
        }

        return ok(account);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable String accountNumber, @RequestBody WithdrawRequest withdrawRequest) {
        Account account = repository.get(accountNumber);

        if (account == null || !account.getOwner().equals(withdrawRequest.getRequester()) || !account.has(withdrawRequest.getValue())) {
            return badRequest().build();
        }

        account.withdraw(withdrawRequest.getValue());

        return ok(account);
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable String accountNumber, @RequestBody DepositRequest depositRequest) {
        Account account = repository.get(accountNumber);
        if (account == null || !account.getOwner().equals(depositRequest.getAccountOwner())) {
            return badRequest().build();
        }

        account.deposit(depositRequest.getValue());

        return ok(account);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest request) {
        Account originAccount = repository.get(request.getOriginAccount());
        Account destinationAccount = repository.get(request.getDestinationAccount());

        if (originAccount == null || !originAccount.has(request.getValue()) || originAccount.getOwner().equals(request.getOriginOwner())) {
            return badRequest().body("origin information is invalid.");
        }

        if (destinationAccount == null || destinationAccount.getOwner().equals(request.getOriginOwner())) {
            return badRequest().body("destination information is invalid.");
        }

        originAccount.withdraw(request.getValue());
        destinationAccount.deposit(request.getValue());

        return ok("transfer requested.");
    }

    @GetMapping("/in-debit")
    public ResponseEntity<List<Account>> inDebit() {
        List<Account> inDebits = new ArrayList<>();

        for (var account : repository.getAll()) {
            if (account.getAvailable() > 0) {
                inDebits.add(account);
            }
        }

        if (inDebits.size() > 0) {
            return ok(inDebits);
        }

        return noContent().build();
    }

}