package com.bank.atm.service;

import com.bank.atm.entity.PersonResponse;
import io.reactivex.Single;

public interface PersonService
{
    Single<PersonResponse> getByDocumentNumber(String documentNumber);
}
