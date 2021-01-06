package com.bank.atm.service.Impl;

import com.bank.atm.entity.BalanceAccount;
import com.bank.atm.service.BalanceAccountService;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

@Service
public class BalanceAccountServiceImpl implements BalanceAccountService
{
    @Override
    public Single<BalanceAccount> consultBalanceAcount(String documentNumber)
    {
        return null;
    }
}
