package com.appndigital.fizzbuzz.model

/**
 * Model to manage all FizzBuzz parameters
 */
data class FizzBuzzDto (
    val int1: Int,
    val int2: Int,
    val limit: Int,
    val str1: String,
    val str2: String
    )

/**
 * Function to define string result from position
 */
fun FizzBuzzDto.toString(position: Int): String {
    var result = ""

    if(position % this.int1 == 0) {
        result = str1
    }

    if(position % this.int2 == 0) {
        result += str2
    }

    if(position % this.int1 != 0 && position % this.int2 != 0) {
        result = position.toString()
    }

    return result
}