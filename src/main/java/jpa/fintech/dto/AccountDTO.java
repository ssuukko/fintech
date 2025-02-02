package jpa.fintech.dto;

import lombok.Getter;

@Getter
public class AccountDTO {

    private Long id;
    private String accountNumber;
    private Double balance;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String accountNumber, Double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}