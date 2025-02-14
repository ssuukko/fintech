package jpa.fintech.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class LoginRequestDTO {

    private String username;
    private String password;

}
