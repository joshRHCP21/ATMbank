package com.bank.atm.http.api;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.ValidatePersonResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReniecApi
{
    @POST("/external/reniec/validate")
    Single<ValidatePersonResponse> validateByDocumentNumber(@Body DocumentRequest documentRequest);
}
