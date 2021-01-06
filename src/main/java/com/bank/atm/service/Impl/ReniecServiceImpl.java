package com.bank.atm.service.Impl;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.ReniecResponse;
import com.bank.atm.http.api.ReniecApi;
import com.bank.atm.http.client.ApiClient;
import com.bank.atm.service.ReniecService;
import io.reactivex.Single;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ReniecServiceImpl implements ReniecService
{
    @Override
    public Single<ReniecResponse> validateByDocument(DocumentRequest documentRequest)
    {
        ApiClient apiClient = new ApiClient();
        ReniecApi reniecApiApi = apiClient.getRetrofitReniecApi().create(ReniecApi.class);

        log.info(documentRequest);
        Single<ReniecResponse> reniecResponse = reniecApiApi.validateByDocumentNumber(documentRequest);
        return reniecResponse;
    }
}
