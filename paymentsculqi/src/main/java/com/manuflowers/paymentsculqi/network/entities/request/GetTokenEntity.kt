package com.manuflowers.paymentsculqi.network.entities.request

data class GetTokenEntity(
    val card_number: String,
    val cvv: String,
    val expiration_month: String,
    val expiration_year: String,
    val email: String
)