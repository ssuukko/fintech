package jpa.fintech.controller;

import jpa.fintech.dto.request.LoginRequestDTO;
import jpa.fintech.dto.response.LoginResponseDTO;
import jpa.fintech.dto.response.ResponseAccountDTO;
import jpa.fintech.service.AccountService;
import jpa.fintech.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        boolean isAuthenticated = loginService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        if (isAuthenticated) {
            List<ResponseAccountDTO> accountList = accountService.getAccountList(loginRequestDTO.getUsername());
            return ResponseEntity.ok(new LoginResponseDTO("로그인 성공", accountList.toString()));
        } else {
            return ResponseEntity.badRequest().body(new LoginResponseDTO("로그인 실패", null));
        }
    }
}
