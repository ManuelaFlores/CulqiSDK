package com.manuflowers.paymentsculqi.network.entities.response

class GetInstallmentsResponse(
    val `object`: String,
    val bin: String,
    val card_brand: String,
    val card_type: Any,
    val card_category: String,
    val issuer: Issuer,
    val installmentAllowed: List<Int>
)