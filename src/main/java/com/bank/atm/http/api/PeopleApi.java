package com.bank.atm.http.api;

import com.bank.atm.entity.PersonResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PeopleApi
{
    @GET("/core/persons")
    Single<PersonResponse> validateByDocumentNumber(@Query("documentNumber") String documentNumber);
}
