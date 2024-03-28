package com.oybekdev.currentconverter_jetpackcompose.di

import com.oybekdev.currentconverter_jetpackcompose.data.ConverterApi
import com.oybekdev.currentconverter_jetpackcompose.main.MainRepository
import com.oybekdev.currentconverter_jetpackcompose.main.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getConverterApi(): ConverterApi {
        return Retrofit
            .Builder()
            .baseUrl("https://api.apilayer.com/currency_data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConverterApi::class.java)
    }

    @Singleton
    @Provides
    fun getMainRepository(api:ConverterApi): MainRepository = MainRepositoryImpl(api)
}