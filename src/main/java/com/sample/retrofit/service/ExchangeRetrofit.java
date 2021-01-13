package com.sample.retrofit.service;

import com.sample.retrofit.domain.Exchange;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import java.io.IOException;

public interface ExchangeRetrofit {

    ///latest?base=USD&symbols=KRW,HKD,JPY
    @FormUrlEncoded
    @GET("/latest")
    Call<Exchange> callExchangeInfo(
            @Field("symbols") String symbols,
            @Field("base") String base
    );
}
