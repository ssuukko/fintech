package jpa.fintech.controller;

import jpa.fintech.dto.request.UserRequestJoinDTO;
import jpa.fintech.dto.response.JoinResponse;
import jpa.fintech.entity.User;
import jpa.fintech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<JoinResponse> join(@RequestBody UserRequestJoinDTO requestDTO) {
        return ResponseEntity.ok(userService.join(requestDTO));
    }



    @GetMapping("/{userId}")
    public ResponseEntity<User> findOne(@PathVariable Long userId) {
        User user = userService.findOne(userId);
        return ResponseEntity.ok(user);
    }

}
