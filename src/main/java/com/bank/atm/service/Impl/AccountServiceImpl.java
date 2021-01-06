package com.bank.atm.service.Impl;

import com.bank.atm.entity.AccountResponse;
import com.bank.atm.http.api.AccountApi;
import com.bank.atm.http.client.ApiClient;
import com.bank.atm.service.AccountService;
import io.reactivex.Single;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AccountServiceImpl implements AccountService
{
    @Override
    public Single<AccountResponse> getAccountByCardNumber(String cardNumber)
    {
        ApiClient apiClient = new ApiClient();
        AccountApi accountApi = apiClient.getRetrofitAccountApi().create(AccountApi.class);

        log.info(cardNumber);
        Single<AccountResponse> accountResponse = accountApi.getAccountByCardNumber(cardNumber);

        return accountResponse;
    }
}
