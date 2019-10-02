package io.townsq.bank.controller;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import io.townsq.bank.domain.Account;
import io.townsq.bank.domain.TransferRequest;
import io.townsq.bank.service.AccountService;
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
@RequestMapping("api/v1/Accounts")
public class AccountsController {

    private final AccountService service = new AccountService();

    @GetMapping
    public Account get() {

        return new Account("123", "joao", 100);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> get(@PathVariable String accountNumber) {
        Account account = service.get(accountNumber);
        if (account == null) {
            return notFound().build();
        }

        return ok(account);
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable String accountNumber, @RequestBody DepositRequest request) {
        Account account = service.get(accountNumber);

        if (account == null) {
            return notFound().build();
        }

        account.setAvailable(account.getAvailable() + request.value);

        return ok(account);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest request) {
        Account originAccount = service.get(request.getOriginAccount());
        Account destinationAccount = service.get(request.getDestinationAccount());

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

        for (var account : service.getAll()) {
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

class DepositRequest {
    public double value;
}
