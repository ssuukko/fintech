package jpa.fintech.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Transaction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;  // 출금 계좌

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_account_id")
    private Account targetAccount;  // 입금 계좌

    private int amount;  // 거래 금액

    // 생성자
    public Transaction(Account fromAccount, Account targetAccount, int amount) {
        this.fromAccount = fromAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }
}
