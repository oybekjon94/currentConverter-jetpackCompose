package com.oybekdev.currentconverter_jetpackcompose.data

import com.oybekdev.currentconverter_jetpackcompose.data.model.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ConverterApi {
    @GET("convert")
    @Headers("apikey:jqzW4ZgmKARpNsUQ4XXa3f7g8IQ6p26B")
    suspend fun convertRate(
        @Query("from") from:String,
        @Query("to") to:String,
        @Query("amount") amount:String
    ): Response<ExchangeResponse>
}