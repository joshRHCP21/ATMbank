package com.bank.atm.http.client;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    private HttpLoggingInterceptor interceptor = null;
    private OkHttpClient baseOkHttpClient = null;
    private Retrofit retrofitPeopleApi = null;
    private Retrofit retrofitFingerprintApi = null;
    private Retrofit retrofitReniecApi = null;
    private Retrofit retrofitCardApi = null;
    private Retrofit retrofitAccountApi = null;

    public Retrofit getRetrofitPeopleApi()
    {
        baseOkHttpClient = new OkHttpClient();
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient peopleApiClient = baseOkHttpClient.newBuilder()
                                                       .addInterceptor(interceptor)
                                                       .build();

        retrofitPeopleApi = new Retrofit.Builder()
                                        .baseUrl("20.40.241.122")
                                       //.baseUrl("http://localhost:8080")
                                       .client(peopleApiClient)
                                       .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                       .addConverterFactory(GsonConverterFactory.create())
                                       .build();

        return retrofitPeopleApi;
    }

    public Retrofit getRetrofitFingerprintApi()
    {
        baseOkHttpClient = new OkHttpClient();
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient fingerprintApiClient = baseOkHttpClient.newBuilder()
                .addInterceptor(interceptor)
                .build();

        retrofitFingerprintApi = new Retrofit.Builder()
                .baseUrl("20.40.240.36")
                .baseUrl("http://localhost:8081")
                .client(fingerprintApiClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitFingerprintApi;
    }

    public Retrofit getRetrofitReniecApi()
    {
        baseOkHttpClient = new OkHttpClient();
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient reniecApiClient = baseOkHttpClient.newBuilder()
                .addInterceptor(interceptor)
                .build();

        retrofitReniecApi = new Retrofit.Builder()
                // .baseUrl("10.0.200.188")
                .baseUrl("http://localhost:8082")
                .client(reniecApiClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitReniecApi;
    }

    public Retrofit getRetrofitCardApi()
    {
        baseOkHttpClient = new OkHttpClient();
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient cardApiClient = baseOkHttpClient.newBuilder()
                .addInterceptor(interceptor)
                .build();

        retrofitCardApi = new Retrofit.Builder()
                .baseUrl("20.40.241.214 ")
                //.baseUrl("http://localhost:8083")
                .client(cardApiClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitCardApi;
    }

    public Retrofit getRetrofitAccountApi()
    {
        baseOkHttpClient = new OkHttpClient();
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient accountApiClient = baseOkHttpClient.newBuilder()
                .addInterceptor(interceptor)
                .build();

        retrofitAccountApi = new Retrofit.Builder()
                .baseUrl("20.40.241.155")
                //.baseUrl("http://localhost:8084")
                .client(accountApiClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitAccountApi;
    }
}
