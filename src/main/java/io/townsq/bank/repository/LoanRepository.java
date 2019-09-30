package io.townsq.bank.repository;

import static java.util.Arrays.asList;


import io.townsq.bank.domain.Loan;
import io.townsq.bank.domain.Status;
import java.util.List;

public class LoanRepository {

    private static List<Loan> Loans = asList(
            new Loan("00001-6", 1212, Status.APPROVED),
            new Loan("00002-6", 10000, Status.WAITING),
            new Loan("00003-6", 10000000, Status.DENIED)
    );
}
