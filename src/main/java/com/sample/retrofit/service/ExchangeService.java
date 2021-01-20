package com.sample.retrofit.service;

import com.sample.retrofit.domain.Exchange;
import com.sample.retrofit.domain.ResponseExchange;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import java.io.IOException;
import java.util.List;

public interface ExchangeService {

    ResponseExchange getExchangeInfo(Exchange param) throws IOException;
    Response responseExchange(Exchange param) throws IOException ;
}
