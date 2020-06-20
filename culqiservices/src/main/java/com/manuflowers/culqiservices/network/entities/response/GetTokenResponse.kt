package com.manuflowers.culqiservices.network.entities.response

import com.google.gson.annotations.SerializedName
import com.manuflowers.culqiservices.network.entities.request.Metadata

data class GetTokenResponse(
    @SerializedName("object")
    val `object`: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("creation_date")
    val creation_date: Long,
    @SerializedName("email")
    val email: String,
    @SerializedName("card_number")
    val card_number: String,
    @SerializedName("last_four")
    val last_four: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("iin")
    val iin: Iin,
    @SerializedName("client")
    val client: Client,
    @SerializedName("metadata")
    val metadata: Metadata
)

data class Iin(
    @SerializedName("object")
    val `object`: String,
    @SerializedName("bin")
    val bin: String,
    @SerializedName("card_brand")
    val card_brand: String,
    @SerializedName("card_type")
    val card_type: String,
    @SerializedName("card_category")
    val card_category: String,
    @SerializedName("issuer")
    val issuer: Issuer,
    @SerializedName("installments_allowed")
    val installments_allowed: List<Int>
)

data class Issuer(
    @SerializedName("country")
    val country: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone_number")
    val phoneNumber: Any,
    @SerializedName("website")
    val website: Any
)

data class Client(
    @SerializedName("ip")
    val ip: String,
    @SerializedName("ip_country")
    val ip_country: String,
    @SerializedName("ip_country_code")
    val ip_country_code: String,
    @SerializedName("browser")
    val browser: String,
    @SerializedName("device_fingerprint")
    val device_fingerprint: Any,
    @SerializedName("device_type")
    val device_type: String
)