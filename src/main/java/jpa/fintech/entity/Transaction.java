package jpa.fintech.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {

    @Id @GeneratedValue
    @Column(name = "transaction_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    private int amount;
    private LocalDateTime transactionDate;
    private String transactionType;
    private String status;

    public static Transaction createTransaction(Account account, int amount, String transactionType, String status) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setTransactionType(transactionType);
        transaction.setStatus(status);
        return transaction;
    }
}
