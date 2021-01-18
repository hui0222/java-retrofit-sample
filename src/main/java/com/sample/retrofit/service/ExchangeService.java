package com.sample.retrofit.service;

import com.sample.retrofit.domain.Exchange;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import java.io.IOException;

public interface ExchangeService {

    String getExchangeInfo(Exchange param) throws IOException;
    Response<ResponseBody> responseExchange(Exchange param) throws IOException ;
}
