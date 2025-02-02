package jpa.fintech.controller;

import jpa.fintech.entity.Account;
import jpa.fintech.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<String> create(@RequestBody Account account) {
        String accountNumber = accountService.createAccount(account);
        return new ResponseEntity<>("Account created : " + accountNumber, HttpStatus.CREATED);
    }

    // 로그인을 하면 그 회원에 관한 정보가 남아있음
    // 그 정보를 바탕으로 accountId를 가져오면 됨
    //{
    //  "id": 1
    //  "accountNumber": "123-456-7890"...계좌번호 형식 정해야 함
    //  "accountName": "통장 1",
    //  "balance": 10000
    //}
    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Account> findOne(@PathVariable Long accountId) {
        Account account = accountService.findOne(accountId);
        return ResponseEntity.ok(account);
    }

    //전 계좌 조회 - 메서드명
    @GetMapping("/users/{id}/accounts")
    public ResponseEntity<List<Account>> findByUserId(@PathVariable Long id) {
        List<Account> accounts = accountService.findByUserId(id);
        return ResponseEntity.ok(accounts);
    }
}