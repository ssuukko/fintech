package jpa.fintech.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(nullable = false)
    private Double amount;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private TransactionType type; // 거래 유형 (DEPOSIT, WITHDRAWAL)
//
//    @Column(nullable = false)
//    private LocalDateTime timestamp; // 거래 시간
//
//    @Column(nullable = false)
//    private String description; // 거래 설명
}

