package com.example.service;

import com.example.model.Account;

public interface IAccountService {
    Account findAccountByEmail(String email);
}