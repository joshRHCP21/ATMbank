package com.bank.atm.http.api;

import com.bank.atm.entity.AccountResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccountApi
{
    @GET("/core/accounts")
    Single<AccountResponse> getAccountByCardNumber(@Query("cardNumber") String cardNumber);
}
