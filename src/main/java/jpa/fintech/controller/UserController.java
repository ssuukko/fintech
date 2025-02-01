package jpa.fintech.controller;

import jpa.fintech.entity.User;
import jpa.fintech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    // User DTO 가져오는 것이 맞는지
    // RequestBody가 어떻게 쓰일까
    // 만들면 UserId를 부여해야 함-> 순서대로 1,2,3... -> @GeneratedValue(strategy = GenerationType.IDENTITY)
    public ResponseEntity<String> join(@RequestBody User user) {
        Long userId = userService.join(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created : " + userId);
    }


    // User DTO 가져오는 것이 맞는지
    @GetMapping("/{userId}")
    public ResponseEntity<User> findOne(@PathVariable Long userId) {
        User user = userService.findOne(userId);
        return ResponseEntity.ok(user);
    }

}
