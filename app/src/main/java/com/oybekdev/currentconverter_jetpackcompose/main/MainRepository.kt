package com.oybekdev.currentconverter_jetpackcompose.main

import com.oybekdev.currentconverter_jetpackcompose.data.model.ExchangeResponse
import com.oybekdev.currentconverter_jetpackcompose.utils.Resource

interface MainRepository {
    suspend fun convertRate(
        from:String,
        to:String,
        amount:String
    ): Resource<ExchangeResponse>
}