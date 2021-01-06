package com.bank.atm.controller;

import com.bank.atm.entity.CardResponse;
import com.bank.atm.service.CardService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core/cards")
public class CardController
{
    @Autowired
    private final CardService cardService;

    @GetMapping("/{documentNumber}")
    Single<CardResponse> getCardsByDocumentNumber(@PathVariable String documentNumber)
    {
        return cardService.getCardsByDocumentNumber(documentNumber);
    }
}
