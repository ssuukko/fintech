package jpa.fintech.controller;

import jpa.fintech.dto.LoginDTO;
import jpa.fintech.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        boolean isAuthenticated = loginService.login(loginDTO);
        if (isAuthenticated) {
            return "redirect:/home";
        } else {
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
