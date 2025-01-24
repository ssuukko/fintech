package jpa.fintech.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String accountNumber;
    private String accountName;  // 계좌 별명
    private int balance;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<>();

    public static Account createAccount(User user, String accountNumber, String accountName, int balance) {
        Account account = new Account();
        account.setUser(user);
        account.setAccountNumber(accountNumber);
        account.setAccountName(accountName);
        account.setBalance(balance);
        return account;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }
}