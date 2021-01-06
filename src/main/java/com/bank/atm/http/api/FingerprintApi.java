package com.bank.atm.http.api;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.ValidatePersonResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FingerprintApi
{
    @POST("/core/fingerprints/validate")
    Single<ValidatePersonResponse> getPersonByDocumentNumber(@Body DocumentRequest documentRequest);
}
