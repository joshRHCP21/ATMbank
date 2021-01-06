package com.bank.atm.http.api;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.ReniecResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReniecApi
{
    @POST("/external/reniec/validate")
    Single<ReniecResponse> validateByDocumentNumber(@Body DocumentRequest documentRequest);
}
