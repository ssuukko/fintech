package jpa.fintech.dto;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class TransactionDTO {

    private Long id;
    private Double amount;
    private LocalDateTime transactionDate;
    private String transactionType;

    public TransactionDTO() {}

    public TransactionDTO(Long id, Double amount, LocalDateTime transactionDate, String transactionType) {
        this.id = id;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }
}
