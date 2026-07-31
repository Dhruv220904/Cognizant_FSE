package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class LoanController {

    // In-memory "database" for demo purposes
    private final Map<Long, Loan> loans = Map.of(
            1L, new Loan(1L, 1L, "HOME", 2500000.00, 8.5),
            2L, new Loan(2L, 2L, "AUTO", 850000.00, 9.2)
    );

    @GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return loans.values().stream().collect(Collectors.toList());
    }

    @GetMapping("/loans/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return loans.get(id);
    }
}
