package jpa.fintech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String accountNumber;
    private String accountName;  // 계좌 이름 Ex. 월급 통장, 적금 통장... 개인이 다양한 계좌 생성 가능
    private int balance;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<>();

//    public void deposit(int amount) {
//        this.balance += amount;
//    }
//
//    public void withdraw(int amount) {
//        this.balance -= amount;
//    }
}