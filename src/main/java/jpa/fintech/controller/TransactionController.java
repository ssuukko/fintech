package jpa.fintech.controller;

import jpa.fintech.entity.Account;
import jpa.fintech.entity.Transaction;
import jpa.fintech.service.AccountService;
import jpa.fintech.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/{accountId}/deposit")
    public String deposit(@PathVariable Long accountId,
                          @RequestParam int amount,
                          @RequestParam String targetAccountNumber) {
        boolean success = transactionService.deposit(accountId, targetAccountNumber, amount);
        return success ? "Deposit successful." : "Deposit failed.";
    }
}

