package jpa.fintech.service;

import jpa.fintech.entity.Account;
import jpa.fintech.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public String createAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        // 여기서 id 아니고 accountNumber 를 반환하는게 맞지 않을까
        return savedAccount.getAccountNumber();
    }

    @Transactional
    public Account findOne(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID: " + accountId));
    }

    public List<Account> findByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}