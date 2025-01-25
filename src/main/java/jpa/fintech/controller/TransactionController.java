package jpa.fintech.controller;

import jpa.fintech.entity.Transaction;
import jpa.fintech.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transactions")
    public String create(@RequestBody Transaction transaction, Model model) {
        Long transactionId = transactionService.createTransaction(transaction);
        model.addAttribute("transactionId", transactionId);
        return "transaction-created";
    }

    @GetMapping("/transactions/{transactionId}")
    public String findOne(@PathVariable Long transactionId, Model model) {
        Transaction transaction = transactionService.findOne(transactionId);
        model.addAttribute("transaction", transaction);
        return "transaction";
    }

    @GetMapping("/accounts/{accountId}/transactions")
    public String findByAccountId(@PathVariable Long accountId, Model model) {
        List<Transaction> transactions = transactionService.findByAccountId(accountId);
        model.addAttribute("transactions", transactions);
        return "transactions";
    }
}