package com.sample.retrofit.service.impl;

import com.sample.retrofit.domain.Exchange;
import com.sample.retrofit.service.ExchangeRetrofit;
import com.sample.retrofit.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service("exchangeService")
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    ExchangeRetrofit exchangeRetrofit;

    //문자 전송
    private Response<Exchange> responseExchange(Exchange param) throws IOException {

        Response<Exchange> responseExchange = exchangeService.callExchangeInfo(
                param.getSymbols(),
                param.getBase()
        ).execute();

        return  responseExchange;
    }

    @Override
    public void getExchangeInfo(Exchange param) throws IOException {
        Response<Exchange> responseExchange = this.responseExchange(param);
    }



}
