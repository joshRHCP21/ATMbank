package com.bank.atm.entity;

import com.bank.atm.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BalanceAccount
{
    private String fingerprintEntityName;
    private List<AccountDto> validAccounts;
    private Double customerAmount;
}
