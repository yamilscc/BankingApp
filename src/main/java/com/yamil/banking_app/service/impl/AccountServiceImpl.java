package com.yamil.banking_app.service.impl;
import com.yamil.banking_app.dto.AccountDto;
import com.yamil.banking_app.entity.Account;
import com.yamil.banking_app.mapper.AccountMapper;
import com.yamil.banking_app.repository.AccountRepository;
import com.yamil.banking_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired //No es necesaria esta annotation desde Spring 4.3
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override //Aquí implementamos el método abstracto de la interfaz AccountService
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account); //Guardamos en la DB

        return AccountMapper.mapToAccountDto(savedAccount); //Devolvemos la entidad persistida y actualizada
    }
}
