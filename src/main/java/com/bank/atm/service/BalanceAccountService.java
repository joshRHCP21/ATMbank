package com.bank.atm.service;


import com.bank.atm.entity.BalanceAccount;
import io.reactivex.Single;

public interface BalanceAccountService
{
    Single<BalanceAccount> consultBalanceAcount(String documentNumber);
}
