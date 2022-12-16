package com.grsu.cherniavskij.horserace.controller;

import com.grsu.cherniavskij.horserace.model.Account;
import com.grsu.cherniavskij.horserace.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final static String ACCOUNT_PATH = "/ACCOUNT";
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(ACCOUNT_PATH + "/{id}")
    public Account getAccountById(@PathVariable("id") Long id) {
        return accountRepository.getById(id);
    }
    @GetMapping(ACCOUNT_PATH)
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}