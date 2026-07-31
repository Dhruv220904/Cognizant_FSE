package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AccountController {

    // In-memory "database" for demo purposes
    private final Map<Long, Account> accounts = Map.of(
            1L, new Account(1L, "Dhruv Sharma", "SAVINGS", 25000.00),
            2L, new Account(2L, "Priya Nair", "CURRENT", 78500.50)
    );

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accounts.values().stream().collect(Collectors.toList());
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accounts.get(id);
    }
}
