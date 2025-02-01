package jpa.fintech.dto;

import lombok.Getter;

@Getter
public class AccountDto {

    private Long id;
    private String accountNumber;
    private Double balance;

    public AccountDto() {
    }

    public AccountDto(Long id, String accountNumber, Double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}