package com.bank.atm.service.Impl;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.PersonResponse;
import com.bank.atm.entity.ValidatePersonResponse;
import com.bank.atm.http.api.PeopleApi;
import com.bank.atm.http.client.ApiClient;
import com.bank.atm.service.FingerprintService;
import com.bank.atm.service.PersonService;
import com.bank.atm.service.ReniecService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class PersonServiceImpl implements PersonService
{
    @Autowired
    private final FingerprintService fingerprintService;

    @Autowired
    private final ReniecService reniecService;

    @Override
    public Single<PersonResponse> getByDocumentNumber(String documentNumber)
    {
        ApiClient apiClient = new ApiClient();
        PeopleApi peopleApi = apiClient.getRetrofitPeopleApi().create(PeopleApi.class);

        log.info(documentNumber);
        Single<PersonResponse> personResponse = peopleApi.validateByDocumentNumber(documentNumber);

        return personResponse;
    }

    @Override
    public Single<ValidatePersonResponse> validatePersonByDocumentNumber(String documentNumber)
    {
        return  getByDocumentNumber(documentNumber)
                    .map(personResponse -> fingerprintService.validateFingerPrintByDocument(new DocumentRequest(documentNumber)))
                    .doOnError(throwable -> log.error(throwable.getMessage()))
                    .flatMap(validatePersonResponseSingle -> validatePersonResponseSingle)
                    .flatMap(validatePersonResponse1 -> validatePersonResponse1.isSuccess() ? reniecService.validateByDocument(new DocumentRequest(documentNumber)) : Single.just(validatePersonResponse1));
    }
}
