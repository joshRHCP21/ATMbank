package com.bank.atm.controller;

import com.bank.atm.entity.DocumentRequest;
import com.bank.atm.entity.ValidatePersonResponse;
import com.bank.atm.service.FingerprintService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atm/fingerprint")
@Log4j2
public class FingerprintController
{
    @Autowired
    private final FingerprintService fingerprintService;

    @PostMapping("/validate")
    public Single<ValidatePersonResponse> validateFingerprintByDocument(@RequestBody DocumentRequest documentRequest)
    {
        return fingerprintService.validateFingerPrintByDocument(documentRequest);
    }
}
