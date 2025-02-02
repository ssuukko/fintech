package jpa.fintech.dto;

import lombok.Getter;


// DTO 어카노
// 이거 다 USER 있는건데...
@Getter
public class LoginDTO {

    private String username;
    private String password;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
