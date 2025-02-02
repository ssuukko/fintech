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
    public Account findOne(Long accountId) {
        return accountRepository.findByAccountId(accountId)
                // 예외 처리 따로 만드는게 낫을려나?
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID: " + accountId));
    }

    // 메서드명
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account with number " + accountNumber + " not found"));
    }

    // 메서드명
    public List<Account> findByUserId(Long id) {
        return accountRepository.findByUserId(id);
    }

    @Transactional
    public String deposit(Long accountId, int amount) {
        Account account = findOne(accountId);

        if (!isValidDepositAmount(amount)) {
            return "입금 금액은 0원 보다 커야 함";
        }

        performDeposit(account, amount);

        return "입금 완료";
    }

    // 출금 처리
    @Transactional
    public String withdraw(Long accountId, int amount) {
        Account account = findOne(accountId);

        if (!isValidWithdrawAmount(amount)) {
            return "출금 금액은 0원 보다 커야함";
        }

        if (!hasSufficientBalance(account, amount)) {
            return "잔액 부족";
        }

        performWithdraw(account, amount);

        return "출금 완료";
    }

    // 입금 금액 검증
    private boolean isValidDepositAmount(int amount) {
        return amount > 0;
    }

    // 출금 금액 검증
    private boolean isValidWithdrawAmount(int amount) {
        return amount > 0;
    }

    // 잔액이 충분한지 확인
    private boolean hasSufficientBalance(Account account, int amount) {
        return account.getBalance() >= amount;
    }

    // 입금 처리
    private void performDeposit(Account account, int amount) {
        account.deposit(amount);
        // 계좌 정보 저장
        save(account);  // 계좌 정보 저장
    }

    // 출금 처리
    private void performWithdraw(Account account, int amount) {
        account.withdraw(amount);
        // 계좌 정보 저장
        save(account);  // 계좌 정보 저장
    }

    // 계좌 저장
    private void save(Account account) {
        accountRepository.save(account);
    }
}
