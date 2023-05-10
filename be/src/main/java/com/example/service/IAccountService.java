package com.example.service;

import com.example.dto.IAccountDTO;
import com.example.model.Account;

public interface IAccountService {
    Account findAccountByEmail(String email);

    IAccountDTO findCartIdByAccountId(Long accountId);

    Account findAccountById(Long id);
}
