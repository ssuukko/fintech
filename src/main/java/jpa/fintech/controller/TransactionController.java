package jpa.fintech.controller;

import jpa.fintech.entity.Account;
import jpa.fintech.entity.Transaction;
import jpa.fintech.service.AccountService;
import jpa.fintech.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    // 입금 처리
    @PostMapping("/accounts/{accountId}/deposit")
    public String deposit(@PathVariable Long accountId, @RequestParam int amount, @RequestParam String targetAccountNumber) {
        // 출금 계좌와 입금 계좌를 조회
        Account fromAccount = findAccountById(accountId);
        Account targetAccount = findAccountByAccountNumber(targetAccountNumber);

        // 계좌가 유효한지 확인
        if (fromAccount == null || targetAccount == null) {
            return "Account not found.";
        }

        // 잔액이 충분한지 확인
        if (!hasSufficientBalance(fromAccount, amount)) {
            return "Insufficient balance.";
        }

        // 입금 처리
        performDeposit(fromAccount, targetAccount, amount);

        return "Deposit successful.";
    }



    // 계좌 ID로 계좌 조회
    private Account findAccountById(Long accountId) {
        return accountService.findOne(accountId);
    }

    // 계좌 번호로 계좌 조회
    private Account findAccountByAccountNumber(String accountNumber) {
        return accountService.findByAccountNumber(accountNumber);
    }

    // 잔액이 충분한지 확인
    private boolean hasSufficientBalance(Account fromAccount, int amount) {
        return fromAccount.getBalance() >= amount;
    }

    // 입금 처리
    private void performDeposit(Account fromAccount, Account targetAccount, int amount) {
        fromAccount.withdraw(amount);
        targetAccount.deposit(amount);

        // 거래 내역 생성
        Transaction transaction = new Transaction(fromAccount, targetAccount, amount);
        transactionService.createTransaction(transaction);

        // 계좌 정보 저장
//        accountService.save(fromAccount);
//        accountService.save(targetAccount);
    }
}
