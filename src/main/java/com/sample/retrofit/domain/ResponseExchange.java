package com.sample.retrofit.domain;

import lombok.Data;

import java.util.List;

@Data
public class ResponseExchange {
    Object rates;
    String base;
    String date;
}
