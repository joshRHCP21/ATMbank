package com.bank.atm.controller;

import com.bank.atm.entity.BalanceAccount;
import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.service.BalanceAccountService;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/atm")
@Api("/atm")
public class BalanceAccountController
{
    @Autowired
    private final BalanceAccountService balanceAccountService;

    @PostMapping("/deposits")
    @ApiOperation(value = "Check Balance Account by Document Number", notes = "Retrieving the Balance Account ", response = BalanceAccount.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = BalanceAccount.class)
    })
    public Single<BalanceAccount> consultBalanceAcountByDocumentNumber(@RequestBody DocumentRequest documentRequest)
    {
        return balanceAccountService.consultBalanceAccount(documentRequest.getDocument());
    }

}
