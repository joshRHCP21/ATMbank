package com.bank.atm.service;


import com.bank.atm.entity.BalanceAccount;
import com.bank.atm.entity.ValidatePersonResponse;
import io.reactivex.Single;

public interface BalanceAccountService
{
    Single<BalanceAccount> consultBalanceAcount(String documentNumber);
    Single<BalanceAccount> getConsultBalanceAcountMapped(String documentNumber, ValidatePersonResponse validatePersonResponse);
}
