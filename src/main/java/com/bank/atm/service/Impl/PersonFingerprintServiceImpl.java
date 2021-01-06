package com.bank.atm.service.Impl;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.FingerprintResponse;
import com.bank.atm.http.api.FingerprintApi;
import com.bank.atm.http.client.ApiClient;
import com.bank.atm.service.FingerprintService;
import io.reactivex.Single;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PersonFingerprintServiceImpl implements FingerprintService
{
    @Override
    public Single<FingerprintResponse> validateFingerPrintByDocument(DocumentRequest documentRequest)
    {
        ApiClient apiClient = new ApiClient();
        FingerprintApi fingerprintApi = apiClient.getRetrofitFingerprintApi().create(FingerprintApi.class);

        log.info(documentRequest);
        Single<FingerprintResponse> fingerprintResponse = fingerprintApi.getPersonByDocumentNumber(documentRequest);
        return fingerprintResponse;
    }
}
