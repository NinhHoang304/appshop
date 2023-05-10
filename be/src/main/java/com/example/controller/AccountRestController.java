package com.example.controller;

import com.example.model.Account;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/account")
public class AccountRestController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("/info/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        Account account = this.accountService.findAccountById(accountId);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
