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


    //get -  찾고자 하는 확실한 정보를 꺼내올때
    //find - 있는지 없는지 확인할 때.. 대부분 Optional 반환

    //테이블 따로
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
