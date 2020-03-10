package com.manuflowers.paymentsculqi.utils

fun luhn(number: String): Boolean {
    var s1 = 0
    var s2 = 0
    val reverse = StringBuffer(number).reverse().toString()
    for (i in 0 until reverse.length) {
        val digit = Character.digit(reverse[i], 10)
        if (i % 2 == 0) {//this is for odd digits, they are 1-indexed in the algorithm
            s1 += digit
        } else {//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
            s2 += 2 * digit
            if (digit >= 5) {
                s2 -= 9
            }
        }
    }
    return (s1 + s2) % 10 == 0
}