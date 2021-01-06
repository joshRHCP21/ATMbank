package com.bank.atm.http.api;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.FingerprintResponse;
import com.bank.atm.entity.PersonResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FingerprintApi
{
    @POST("/core/fingerprints/validate")
    Single<FingerprintResponse> getPersonByDocumentNumber(@Body DocumentRequest documentRequest);
}
