package com.oybekdev.currentconverter_jetpackcompose.utils

import com.oybekdev.currentconverter_jetpackcompose.data.model.ExchangeResponse

sealed class ConvertEvent{
    data class Success(val result: ExchangeResponse):ConvertEvent()
    data class Error(val errorMessage:String?):ConvertEvent()
    object Loading:ConvertEvent()
    object Empty:ConvertEvent()
}