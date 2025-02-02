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

    // 메서드명
    @Transactional
    public Account findOne(Long accountId) {
        return accountRepository.findByAccountId(accountId)
                // 예외 처리 따로 만드는게 낫을려나?
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID: " + accountId));
    }

    // 메서드명
    public List<Account> findByUserId(Long id) {
        return accountRepository.findByUserId(id);
    }

    // 입금 처리
    @Transactional
    public String deposit(Long accountId, int amount) {
        // 계좌 조회
        Account account = findOne(accountId);

        // 입금 금액이 0 이상인지 확인
        if (amount <= 0) {
            return "Deposit amount must be greater than 0.";
        }

        // 입금 처리
        account.deposit(amount);

        // 계좌 정보 저장
        accountRepository.save(account);

        return "Deposit successful.";
    }

    // 출금 처리
    @Transactional
    public String withdraw(Long accountId, int amount) {
        // 계좌 조회
        Account account = findOne(accountId);

        // 출금 금액이 0 이상인지 확인
        if (amount <= 0) {
            return "Withdrawal amount must be greater than 0.";
        }

        // 잔액이 부족하면 예외 발생
        if (account.getBalance() < amount) {
            return "Insufficient balance.";
        }

        // 출금 처리
        account.withdraw(amount);

        // 계좌 정보 저장
        accountRepository.save(account);

        return "Withdrawal successful.";
    }

    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account with number " + accountNumber + " not found"));
    }

    public void save(Account account) {
        accountRepository.save(account);
    }
}
