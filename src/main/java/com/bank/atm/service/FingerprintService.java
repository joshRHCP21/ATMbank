package com.bank.atm.service;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.FingerprintResponse;
import io.reactivex.Single;

public interface FingerprintService
{
    Single<FingerprintResponse> validateFingerPrintByDocument(DocumentRequest documentRequest);
}
