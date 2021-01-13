package com.sample.retrofit.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.retrofit.service.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class RetrofitConfig {

    //https://api.exchangeratesapi.io/latest?base=USD&symbols=KRW,HKD,JPY
    public String SERVER_URL = "https://api.exchangeratesapi.io";


    @Bean
    public OkHttpClient okHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(chain -> {
                    Request request = chain.request();

                    long t1 = System.nanoTime();

                    Response response = chain.proceed(request);

                    long t2 = System.nanoTime();

                    return response;
                })
                .addInterceptor(loggingInterceptor)
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();

        //log.debug("OkHttpClient LoggingInterceptor");
        return httpClient;
    }

    @Bean
    public Retrofit retrofit(final OkHttpClient client) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().failOnUnknownProperties(false).build();
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .baseUrl(this.SERVER_URL)
                .client(client)
                .build();
    }

    @Bean
    public ExchangeService exchangeService(final Retrofit retrofit) {
        return retrofit.create(ExchangeService.class);
    }


    /*
    @Bean
    public SmsService scheduleApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                // .connectionSpecs(Collections.singletonList(spec))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SMS_SERVER_URL)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(SmsService.class);
    }

     */

}