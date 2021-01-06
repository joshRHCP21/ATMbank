package com.bank.atm.controller;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.ValidatePersonResponse;
import com.bank.atm.service.ReniecService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/external/reniec")
@Log4j2
public class ReniecController
{
    @Autowired
    private final ReniecService reniecService;

    @PostMapping("/validate")
    public Single<ValidatePersonResponse> validatePersonByDocument(@RequestBody DocumentRequest documentRequest)
    {
        return reniecService.validateByDocument(documentRequest);
    }
}
