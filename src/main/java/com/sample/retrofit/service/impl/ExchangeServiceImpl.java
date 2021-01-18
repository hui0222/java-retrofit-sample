package com.sample.retrofit.service.impl;

import com.sample.retrofit.domain.Exchange;
import com.sample.retrofit.service.ExchangeRetrofit;
import com.sample.retrofit.service.ExchangeService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {


    private final ExchangeRetrofit exchangeRetrofit;

    @Autowired
    public ExchangeServiceImpl(ExchangeRetrofit exchangeRetrofit) {
        this.exchangeRetrofit = exchangeRetrofit;
    }


    @Override
    public Response<ResponseBody> responseExchange(Exchange param) throws IOException {

        Call<ResponseBody> call = exchangeRetrofit.callExchangeInfo(
                param.getSymbols(),
                param.getBase()
        );

        Response<ResponseBody> response = call.execute();

        return  response;
    }

    @Override
    public String getExchangeInfo(Exchange param) throws IOException {
        Response<ResponseBody> responseExchange = this.responseExchange(param);

        Map<String, Object> map = new HashMap<>();
        return responseExchange.body().source().toString();

    }


}
