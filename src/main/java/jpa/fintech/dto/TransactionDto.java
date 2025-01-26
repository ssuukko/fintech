package jpa.fintech.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class TransactionDto {

    private Long id;
    private Double amount;
    private LocalDateTime transactionDate;
    private String transactionType;

    public TransactionDto() {}

    public TransactionDto(Long id, Double amount, LocalDateTime transactionDate, String transactionType) {
        this.id = id;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }
}
