package com.bank.atm.service;


import com.bank.atm.entity.BalanceAccount;
import com.bank.atm.entity.ValidatePersonResponse;
import io.reactivex.Single;

public interface BalanceAccountService
{
    Single<BalanceAccount> consultBalanceAccount(String documentNumber);
    Single<BalanceAccount> getConsultBalanceAccountMapped(String documentNumber, ValidatePersonResponse validatePersonResponse);
}
