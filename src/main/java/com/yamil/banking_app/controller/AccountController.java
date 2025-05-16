package com.yamil.banking_app.controller;

import com.yamil.banking_app.dto.AccountDto;
import com.yamil.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return new ResponseEntity(accountService.getAccountById(id), HttpStatus.OK); //Tambien podriamos utilizar el método ResponseEntity.ok(...) y devuelve HTTP Status de 200
    }

    // Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request) {

        Double amount = request.get("amount");
        return new ResponseEntity<AccountDto>(accountService.deposit(id, amount), HttpStatus.OK);
    }

    //Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request) {
        Double amount = request.get("amount");
        return new ResponseEntity<AccountDto>(accountService.withdraw(id, amount), HttpStatus.OK);
    }
}
