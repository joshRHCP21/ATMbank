package com.bank.atm.controller;

import com.bank.atm.entity.PersonResponse;
import com.bank.atm.service.PersonService;
import io.reactivex.Single;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atm/people")
@Log4j2
public class PersonController
{
    @Autowired
    private final PersonService personService;

    @GetMapping("/{documentNumber}")
    Single<PersonResponse> getPersonByDocumentNumber(@PathVariable String documentNumber)
    {
        log.info(documentNumber);
        return personService.getByDocumentNumber(documentNumber);
    }

}
