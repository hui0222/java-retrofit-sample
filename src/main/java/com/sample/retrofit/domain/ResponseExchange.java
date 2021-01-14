package com.sample.retrofit.domain;

import lombok.Data;

@Data
public class ResponseExchange {
    String usd;
    String jpy;
    String symbols;
    String base;

    Object rates;
    String date;
}
