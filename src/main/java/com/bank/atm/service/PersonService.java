package com.bank.atm.service;

import com.bank.atm.entity.PersonResponse;
import com.bank.atm.entity.ValidatePersonResponse;
import io.reactivex.Single;

public interface PersonService
{
    Single<PersonResponse> getByDocumentNumber(String documentNumber);
    Single<ValidatePersonResponse> validatePersonByDocumentNumber(String documentNumber);
}
