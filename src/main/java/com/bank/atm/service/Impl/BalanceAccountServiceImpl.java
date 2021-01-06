package com.bank.atm.service.Impl;

import com.bank.atm.dto.AccountDto;
import com.bank.atm.entity.*;
import com.bank.atm.service.*;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static io.reactivex.schedulers.Schedulers.io;

@Service
@RequiredArgsConstructor
@Log4j2
public class BalanceAccountServiceImpl implements BalanceAccountService
{
    @Autowired
    private final PersonService personService;

    @Autowired
    private final FingerprintService fingerprintService;

    @Autowired
    private final ReniecService reniecService;

    @Autowired
    private final AccountService accountService;

    @Autowired
    private final CardService cardService;

    @Override
    public Single<BalanceAccount> consultBalanceAccount(String documentNumber)
    {
        Single<BalanceAccount> balanceAccount = personService.validatePersonByDocumentNumber(documentNumber)
                                                             .flatMap(validatePersonResponse -> getConsultBalanceAccountMapped(documentNumber, validatePersonResponse))
                                                             .doOnError(throwable -> log.error(throwable));

        return balanceAccount;
    }

    @Override
    public Single<BalanceAccount> getConsultBalanceAccountMapped(String documentNumber, ValidatePersonResponse validatePersonResponse)
    {
        return cardService.getCardsByDocumentNumber(documentNumber)
                          .map(cardResponse -> {
                              List<AccountResponse> activeCards =
                                      cardService.getCardsByDocumentNumber(documentNumber)
                                                 .map(cardResponse1 -> cardResponse1.getCards())
                                                 .map(cards -> cards.stream())
                                                 .blockingGet()
                                                 .filter(card -> card.isActive())
                                                 .parallel()
                                                 .map(c -> accountService.getCardByCardNumber(c.getCardNumber())
                                                                         //.subscribeOn(Schedulers.newThread())
                                                                         .toObservable())

                                                 .map(ac -> ac.blockingFirst())
                                                 .collect(Collectors.toList())
                                                 ;

                              Double totalAmount = activeCards.stream()
                                                              .mapToDouble(card -> card.getAmount())
                                                              .sum();

                              List<AccountDto> cards = activeCards.stream()
                                                                  .map(cardResp -> new AccountDto(cardResp.getAccountNumber()))
                                                                  .collect(Collectors.toList());

                              BalanceAccount balanceAccount = new BalanceAccount(validatePersonResponse.getEntityName(),
                                                                                 cards,
                                                                                 totalAmount);

                              return balanceAccount;
                          });
    }
}
