package jpa.fintech.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseLoginAccountDTO {
    private Long id;
    private String accountNumber;
    private String accountName;
}


