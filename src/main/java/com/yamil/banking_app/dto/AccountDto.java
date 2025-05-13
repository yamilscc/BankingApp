package com.yamil.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {

    public Long id;
    private String accountHolderName;
    private double balance;
}
