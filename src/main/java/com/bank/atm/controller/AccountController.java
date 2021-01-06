package com.bank.atm.controller;

import com.bank.atm.entity.AccountResponse;
import com.bank.atm.service.AccountService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core/accounts")
@Log4j2
public class AccountController
{
    @Autowired
    private final AccountService accountService;

    @GetMapping("/{cardNumber}")
    public Single<AccountResponse> getCardByCardNumber(@PathVariable String cardNumber)
    {
        return accountService.getAccountByCardNumber(cardNumber);
    }
}
