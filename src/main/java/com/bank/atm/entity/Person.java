package com.bank.atm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person
{
    private String id;
    private String document;
    private String name;
    private String lastName;
    private String Sex;
    private boolean fingerprint;
    private boolean blacklist;
}
