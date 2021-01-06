package com.bank.atm.controller;

import com.bank.atm.entity.BalanceAccount;
import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.service.BalanceAccountService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/atm")
public class BalanceAccountController {
    @Autowired
    private final BalanceAccountService balanceAccountService;

    @PostMapping("/deposits")
    public Single<BalanceAccount> consultBalanceAcountByDocumentNumber(@RequestBody DocumentRequest documentRequest)
    {
        return balanceAccountService.consultBalanceAcount(documentRequest.getDocument());
    }

}
