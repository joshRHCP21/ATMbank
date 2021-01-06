package com.bank.atm.service;

import com.bank.atm.entity.CardResponse;
import io.reactivex.Single;

public interface CardService
{
    Single<CardResponse> getCardsByDocumentNumber(String documentNumber);
}
