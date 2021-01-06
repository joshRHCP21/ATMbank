package com.bank.atm.service.Impl;

import com.bank.atm.entity.CardResponse;
import com.bank.atm.http.api.CardApi;
import com.bank.atm.http.client.ApiClient;
import com.bank.atm.service.CardService;
import io.reactivex.Single;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CardServiceImpl implements CardService
{
    @Override
    public Single<CardResponse> getCardsByDocumentNumber(String documentNumber)
    {
        ApiClient apiClient = new ApiClient();
        CardApi cardApi = apiClient.getRetrofitCardApi().create(CardApi.class);

        log.info(documentNumber);
        Single<CardResponse> cardResponse = cardApi.getCardsByDocumentNumber(documentNumber);

        return cardResponse;
    }
}
