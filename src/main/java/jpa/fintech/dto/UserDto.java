package jpa.fintech.dto;

import lombok.Getter;

@Getter
public class UserDto {

    private Long id;
    private String username;

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}