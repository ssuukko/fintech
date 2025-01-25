package jpa.fintech.controller;

import jpa.fintech.entity.User;
import jpa.fintech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String showJoinForm() {
        return "join-form";
    }

    @PostMapping("/users")
    public String join(@ModelAttribute User user, Model model) {
        Long userId = userService.join(user);
        model.addAttribute("userId", userId);
        return "user-created";
    }

    @GetMapping("/users/{userId}")
    public String findOne(@PathVariable Long userId, Model model) {
        User user = userService.findOne(userId);
        model.addAttribute("user", user);
        return "user";
    }
}
