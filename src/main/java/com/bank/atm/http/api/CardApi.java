package com.bank.atm.http.api;

import com.bank.atm.entity.CardResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CardApi
{
    @GET("/core/cards")
    Single<CardResponse> getCardsByDocumentNumber(@Query("documentNumber") String documentNumber);
}
