package com.bank.atm.service.Impl;


import com.bank.atm.entity.*;
import com.bank.atm.service.*;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@Log4j2
@ExtendWith(MockitoExtension.class)
public class BalanceAccountServiceImplTest
{
    @InjectMocks
    private BalanceAccountServiceImpl balanceAccountService;

    @Mock
    private PersonService personService;

    @Mock
    private AccountService accountService;

    @Mock
    private CardService cardService;

    @Test
    public void getConsultBalanceAccountMappedNoErrors()
    {
        List<Card> cards = IntStream.rangeClosed(1, 6)
                                    .mapToObj(number ->
                                            new Card("111122223333444"+number,
                                                    number < 4 ? true : false))
                                    .collect(Collectors.toList());

        Single<AccountResponse> accountResponseSingle1 = Single.just(new AccountResponse("1111222233334441XXX", 10.0));
        Single<AccountResponse> accountResponseSingle2 = Single.just(new AccountResponse("1111222233334442XXX", 30.0));
        Single<AccountResponse> accountResponseSingle3 = Single.just(new AccountResponse("1111222233334443XXX", 60.0));

        Single<CardResponse> cardResponseSingle = Single.just(new CardResponse(cards));

        when(cardService.getCardsByDocumentNumber(anyString())).thenReturn(cardResponseSingle);

        when(accountService.getAccountByCardNumber("1111222233334441")).thenReturn(accountResponseSingle1);
        when(accountService.getAccountByCardNumber("1111222233334442")).thenReturn(accountResponseSingle2);
        when(accountService.getAccountByCardNumber("1111222233334443")).thenReturn(accountResponseSingle3);

        BalanceAccount balanceAccount = new BalanceAccount();

        Single<BalanceAccount> balanceAccountToTest = balanceAccountService.getConsultBalanceAccountMapped("7623432234", new ValidatePersonResponse("Core", true));

        balanceAccountToTest.test().assertNoErrors();
    }

    @Test
    public void getConsultBalanceAccountNoErrors()
    {
        List<Card> cards = IntStream.rangeClosed(1, 6)
                .mapToObj(number ->
                        new Card("111122223333444"+number,
                                number < 4 ? true : false))
                .collect(Collectors.toList());

        Single<AccountResponse> accountResponseSingle1 = Single.just(new AccountResponse("1111222233334441XXX", 10.0));
        Single<AccountResponse> accountResponseSingle2 = Single.just(new AccountResponse("1111222233334442XXX", 30.0));
        Single<AccountResponse> accountResponseSingle3 = Single.just(new AccountResponse("1111222233334443XXX", 60.0));

        Single<CardResponse> cardResponseSingle = Single.just(new CardResponse(cards));

        Single<ValidatePersonResponse> validatePersonResponse = Single.just(new ValidatePersonResponse("Core", true));

        when(cardService.getCardsByDocumentNumber(anyString())).thenReturn(cardResponseSingle);

        when(accountService.getAccountByCardNumber("1111222233334441")).thenReturn(accountResponseSingle1);
        when(accountService.getAccountByCardNumber("1111222233334442")).thenReturn(accountResponseSingle2);
        when(accountService.getAccountByCardNumber("1111222233334443")).thenReturn(accountResponseSingle3);

        when(personService.validatePersonByDocumentNumber("73431156")).thenReturn(validatePersonResponse);

        BalanceAccount balanceAccount = new BalanceAccount();

        Single<BalanceAccount> balanceAccountToTest = balanceAccountService.consultBalanceAccount("73431156");

        balanceAccountToTest.test().assertNoErrors();
    }
}
