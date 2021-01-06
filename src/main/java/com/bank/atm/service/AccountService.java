package com.bank.atm.service;

import com.bank.atm.entity.AccountResponse;
import io.reactivex.Single;

public interface AccountService
{
    Single<AccountResponse> getAccountByCardNumber(String cardNumber);
}
