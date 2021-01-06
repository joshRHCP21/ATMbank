package com.bank.atm.entity;

import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponse
{
    List<Card> cards;
}
