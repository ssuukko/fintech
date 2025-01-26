package jpa.fintech.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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