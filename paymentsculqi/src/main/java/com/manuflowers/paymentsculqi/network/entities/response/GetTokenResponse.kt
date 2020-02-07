package com.manuflowers.paymentsculqi.network.entities.response

data class GetTokenResponse(
    val `object`: String,
    val id: String,
    val type: String,
    val creation_date: Any,
    val email: String,
    val card_number: String,
    val last_four: String,
    val active: Boolean,
    val iin: Inn,
    val client: Client,
    val metadata: Any? = null
)

data class Inn(
    val `object`: String,
    val bin: String,
    val card_brand: String,
    val card_type: String,
    val card_category: String,
    val issuer: Issuer,
    val installments_allowed: List<Int>
)

data class Issuer(
    val name: String,
    val country: String,
    val country_code: String,
    val website: String?,
    val phone_number: Int?
)

data class Client(
    val ip: String,
    val ip_country: String,
    val ip_country_code: String,
    val browser: String,
    val device_fingerprint: String?,
    val device_type: String
)