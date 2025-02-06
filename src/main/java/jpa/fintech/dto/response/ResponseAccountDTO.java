package jpa.fintech.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ResponseAccountDTO {
    private Long id;
    private String accountNumber;
    private String accountName;
    private int balance;

}
