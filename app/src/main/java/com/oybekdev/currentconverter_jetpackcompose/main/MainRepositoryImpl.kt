package com.oybekdev.currentconverter_jetpackcompose.main

import com.oybekdev.currentconverter_jetpackcompose.data.ConverterApi
import com.oybekdev.currentconverter_jetpackcompose.data.model.ExchangeResponse
import com.oybekdev.currentconverter_jetpackcompose.utils.Resource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: ConverterApi
):MainRepository {
    override suspend fun convertRate(
        from: String,
        to: String,
        amount: String,
    ): Resource<ExchangeResponse> {
        return try {
            val response = api.convertRate(from,to,amount)
            if (response.isSuccessful && response.body() != null){
                Resource.Success(response.body())
            }else{
                Resource.Error(response.message())
            }
        }catch (e:Exception){
            Resource.Error(e.message)
        }
    }

}