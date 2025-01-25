package jpa.fintech.dto;

import java.time.LocalDateTime;

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

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
