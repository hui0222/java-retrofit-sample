package com.sample.retrofit.service.impl;

import com.sample.retrofit.domain.Exchange;
import com.sample.retrofit.domain.ResponseExchange;
import com.sample.retrofit.service.ExchangeRetrofit;
import com.sample.retrofit.service.ExchangeService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {


    private final ExchangeRetrofit exchangeRetrofit;

    @Autowired
    public ExchangeServiceImpl(ExchangeRetrofit exchangeRetrofit) {
        this.exchangeRetrofit = exchangeRetrofit;
    }


    @Override
    public Response responseExchange(Exchange param) throws IOException {

        Call<ResponseExchange> call = exchangeRetrofit.callExchangeInfo(
                param.getSymbols(),
                param.getBase()
        );

        Response response = call.execute();

        return  response;
    }

    @Override
    public ResponseExchange getExchangeInfo(Exchange param) throws IOException {
        Response responseExchange = this.responseExchange(param);

        ResponseExchange exchange = (ResponseExchange) responseExchange.body();
        return exchange;

    }


}
