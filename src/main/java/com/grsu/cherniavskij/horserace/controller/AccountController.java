package com.grsu.cherniavskij.horserace.controller;

import com.grsu.cherniavskij.horserace.model.Account;
import com.grsu.cherniavskij.horserace.model.Horse;
import com.grsu.cherniavskij.horserace.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
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
    @PostMapping(value = ACCOUNT_PATH)
    public Long createAccount(@RequestBody Account account) {
        return accountRepository.save(account).getId();
    }

    @PutMapping(ACCOUNT_PATH + "/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable long id, @RequestBody Account account) {
        Account updateAccount = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not exist with id: " + id));

        updateAccount.setAddress(account.getAddress());
        updateAccount.setBalance(account.getBalance());
        updateAccount.setDateRegisterAccount(account.getDateRegisterAccount());
        updateAccount.setDelete(account.getDelete());
        updateAccount.setEmail(account.getEmail());
        updateAccount.setBalance(account.getBalance());
        updateAccount.setDateBirth(account.getDateBirth());
        updateAccount.setFirstName(account.getFirstName());
        updateAccount.setLastName(account.getLastName());
        updateAccount.setLogin(account.getLogin());
        updateAccount.setPassword(account.getPassword());
        updateAccount.setStatus(account.getStatus());

        return ResponseEntity.ok(updateAccount);
    }
    @DeleteMapping(value = ACCOUNT_PATH + "/{id}")
    public ResponseEntity<Long> deleteAccount(@PathVariable Long id) {

        accountRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping(ACCOUNT_PATH)
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}