package com.yamil.banking_app.service.impl;
import com.yamil.banking_app.dto.AccountDto;
import com.yamil.banking_app.entity.Account;
import com.yamil.banking_app.mapper.AccountMapper;
import com.yamil.banking_app.repository.AccountRepository;
import com.yamil.banking_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AccountDto getAccountById(Long id) {

        AccountDto response = AccountMapper.
                mapToAccountDto(accountRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("La cuenta no existe!"))); //Busca la cuenta por ID, sino la encuentra, retorna una RuntimeException. Fue necesario el mapper, ya que el método orElseThrow() (que en el fondo es casi un get()) devuelve el mismo tipo de dato que nuestro modelo o Entity (en nuestro caso, Account)

        return response;
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account accountAsIs = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("La cuenta no existe!")); //Obtenemos el estado actual (As Is) de la cuenta

        double total = accountAsIs.getBalance() + amount; //Saldo actual + depósito
        accountAsIs.setBalance(total); // Actualizamos el saldo de la cuenta

        return AccountMapper.mapToAccountDto(accountRepository.save(accountAsIs)); //Guardamos la cuenta con saldo modificado en la DB y hacemos la conversión a DTO.
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account accountAsIs = accountRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("La cuenta no existe!"));

        if(accountAsIs.getBalance() < amount) {
            throw new RuntimeException("Saldo insuficiente!");
        }
        double total = accountAsIs.getBalance() - amount; //Saldo actual - extracción
        accountAsIs.setBalance(total); // Actualizamos el saldo de la cuenta

        return AccountMapper.mapToAccountDto(accountRepository.save(accountAsIs)); //Guardamos la cuenta con saldo modificado en la DB y hacemos la conversión a DTO.
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<AccountDto> accountList = accountRepository
                            .findAll() //Obtenemos todas las cuentas
                            .stream()//Utilizamos el recurso stream
                            .map(AccountMapper::mapToAccountDto) //Hacemos el mapping con un Method Reference
                            .toList(); //Convertimos el stream resultante en una lista
        return accountList;
    }

    @Override
    public void deleteAccount(Long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("La cuenta no se puede borrar porque no existe!")); //Chequeamos que la cuenta exista

        accountRepository.delete(account); //Si la cuenta entonces existe, se borra con esta sentencia
    }


}
