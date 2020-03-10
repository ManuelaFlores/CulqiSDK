package com.manuflowers.culqiservices.network.entities.response

data class GetInstallmentsResponse(

    val `object`: String,
    val bin: String,
    val card_brand: String,
    val card_type: Any,
    val card_category: String,
    val issuer: Issuer,
    val installments_allowed: List<Int>
)