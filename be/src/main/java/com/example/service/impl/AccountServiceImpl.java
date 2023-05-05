package com.example.service.impl;

import com.example.dto.IAccountDTO;
import com.example.model.Account;
import com.example.repository.IAccountRepository;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;
    @Override
    public Account findAccountByEmail(String email) {
        return this.accountRepository.findAccountByEmail(email);
    }

    @Override
    public IAccountDTO findCartIdByAccountId(Long accountId) {
        return this.accountRepository.findCartIdByAccountId(accountId);
    }

}
