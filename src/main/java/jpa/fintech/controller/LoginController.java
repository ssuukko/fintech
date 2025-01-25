package jpa.fintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        if ("user".equals(username) && "password".equals(password)) {
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
