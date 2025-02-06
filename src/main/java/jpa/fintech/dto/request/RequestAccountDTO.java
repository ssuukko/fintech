package jpa.fintech.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class RequestAccountDTO {
    private String accountName;
    private int initialBalance;
}
