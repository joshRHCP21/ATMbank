package com.bank.atm.service;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.ValidatePersonResponse;
import io.reactivex.Single;

public interface FingerprintService
{
    Single<ValidatePersonResponse> validateFingerPrintByDocument(DocumentRequest documentRequest);
}
