package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.di

import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.api_remote.ApiServiceInterface
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.repositories_Imp.PostsRepositoryImp
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.utils.Constants
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.repositories.PostsRepositoryI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule= module{
    single { getRetrofitInstance() }
    single { getApiInterface(get()) }

    single<PostsRepositoryI>{
        PostsRepositoryImp(get())
    }
}


fun getRetrofitInstance():Retrofit{
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun getApiInterface(retrofit: Retrofit):ApiServiceInterface = retrofit.create(ApiServiceInterface::class.java)