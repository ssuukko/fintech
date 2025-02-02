package jpa.fintech.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    // id 타입 Long Integer int
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 위에 id는 그냥 운영자 관점에서 식별번호...
    // 로그인 할때 아이디를 만드는게 맞겠지?
    // private int userId;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts = new ArrayList<>();

    public User(Long id, String userId, String username, String password, List<Account> accounts) {
        this.id = id;
//        this.userId = userId;
        this.username = username;
        this.password = password;
        this.accounts = accounts;
    }
}
