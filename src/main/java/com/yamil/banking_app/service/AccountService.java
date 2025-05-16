package com.yamil.banking_app.service;

import com.yamil.banking_app.dto.AccountDto;

public interface AccountService {

    /*"Contrato" entre capas para crear una cuenta*/
    AccountDto createAccount(AccountDto accountDto); //Es la firma del método a implementar (es "public abstract").

    /*Contrato entre capas para obtener una cuenta a partir de su id*/
    AccountDto getAccountById(Long id);

    /*Contrato entre capas para depositar dinero en la cuenta*/
    AccountDto deposit(Long id, double amount);

    /*Contrato entre capas para retirar dinero de la cuenta*/
    AccountDto withdraw(Long id, double amount);
}
