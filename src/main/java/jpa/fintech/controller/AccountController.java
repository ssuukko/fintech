package jpa.fintech.controller;

import jpa.fintech.entity.Account;
import jpa.fintech.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts")
    public String create(@RequestBody Account account, Model model) {
        Long accountId = accountService.createAccount(account);
        model.addAttribute("accountId", accountId);
        return "account-created";
    }

    @GetMapping("/accounts/{accountId}")
    public String findOne(@PathVariable Long accountId, Model model) {
        Account account = accountService.findOne(accountId);
        model.addAttribute("account", account);
        return "account";
    }

    @GetMapping("/users/{userId}/accounts")
    public String findByUserId(@PathVariable Long userId, Model model) {
        List<Account> accounts = accountService.findByUserId(userId);
        model.addAttribute("accounts", accounts);
        return "accounts";
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "accounts";
    }
}