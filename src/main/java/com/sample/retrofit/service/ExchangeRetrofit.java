package com.sample.retrofit.service;

import com.sample.retrofit.domain.Exchange;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.io.IOException;

public interface ExchangeRetrofit {

    ///latest?base=USD&symbols=KRW,HKD,JPY
    //@FormUrlEncoded
    @GET("/latest")
    Call<ResponseBody> callExchangeInfo(
            @Query(value="symbols", encoded=true) String symbols,
            @Query(value="base", encoded=true) String base
            //@Field("symbols") String symbols,
            //@Field("base") String base
    );
}
