package jpa.fintech.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor  // JSON 역직렬화를 위해 필요
public class UserRequestJoinDTO {

    private String userName;
    private String password;

    @Builder
    public UserRequestJoinDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
