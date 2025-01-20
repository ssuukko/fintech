package jpa.fintech.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int loginAttempts;

    @Column(nullable = false)
    private boolean isLocked;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Account> accounts = new ArrayList<>(); // 사용자가 소유한 계좌 목록
//
//    @CreationTimestamp
//    private LocalDateTime createdAt; // 계정 생성일
//
//    @UpdateTimestamp
//    private LocalDateTime updatedAt; // 계정 수정일

}
