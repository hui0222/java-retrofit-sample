package com.sample.retrofit.controller;

import com.sample.retrofit.domain.Exchange;
import com.sample.retrofit.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    @Autowired
    ExchangeService exchangeService;

    @RequestMapping(path = "/exchange/list",method = RequestMethod.GET)
    public String getExchange() throws IOException {
        //base=USD&symbols=KRW,HKD,JPY
        Exchange param = new Exchange();
        param.setBase("USD");
        param.setSymbols("KRW,HKD,JPY");


        String result = exchangeService.getExchangeInfo(param);
        System.out.println(result);

        return "getTest1";
    }


}
