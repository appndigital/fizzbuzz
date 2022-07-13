package com.appndigital.fizzbuzz.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appndigital.fizzbuzz.model.FizzBuzzDto

/**
 * [ViewModel] managing logical and data
 */
class MainViewModel: ViewModel() {

    private val liveFizzBuzz: MutableLiveData<FizzBuzzDto> = MutableLiveData()

    fun getCurrentFizzBuzz() : LiveData<FizzBuzzDto> {
        return liveFizzBuzz
    }

    fun defineFizzBuzz(int1 : Int, int2: Int, limit: Int, str1: String, str2: String) {
        val fizzBuzz = FizzBuzzDto(int1, int2, limit, str1, str2)
        liveFizzBuzz.postValue(fizzBuzz)
    }

}