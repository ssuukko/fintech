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
    public Long createAccount(Account account) {
        accountRepository.save(account);
        return account.getId();
    }

    public Account findOne(Long accountId) {
        return accountRepository.findById(accountId).get();
    }

    public List<Account> findByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}