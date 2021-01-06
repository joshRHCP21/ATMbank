package com.bank.atm.service.Impl;

import com.bank.atm.entity.PersonResponse;
import com.bank.atm.http.api.PeopleApi;
import com.bank.atm.http.client.ApiClient;
import com.bank.atm.service.PersonService;
import io.reactivex.Single;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PersonServiceImpl implements PersonService
{
    @Override
    public Single<PersonResponse> getByDocumentNumber(String documentNumber)
    {
        ApiClient apiClient = new ApiClient();
        PeopleApi peopleApi = apiClient.getRetrofitPeopleApi().create(PeopleApi.class);

        log.info(documentNumber);
        Single<PersonResponse> personResponse = peopleApi.validateByDocumentNumber(documentNumber);

        return personResponse;
    }
}
