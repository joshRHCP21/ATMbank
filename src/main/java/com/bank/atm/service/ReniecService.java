package com.bank.atm.service;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.FingerprintResponse;
import com.bank.atm.entity.ReniecResponse;
import io.reactivex.Single;

public interface ReniecService
{
    Single<ReniecResponse> validateByDocument(DocumentRequest documentRequest);
}
