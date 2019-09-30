package io.townsq.bank.controller;

import io.townsq.bank.domain.Loan;
import io.townsq.bank.service.LoanService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/Loans")
public class LoansController {

    private final LoanService service = new LoanService();

    @GetMapping
    public List<Loan> get() {

        return service.getAll();
    }

    @PostMapping
    public Loan post(@RequestBody Loan loan) {
        return service.create(loan);
    }

}

