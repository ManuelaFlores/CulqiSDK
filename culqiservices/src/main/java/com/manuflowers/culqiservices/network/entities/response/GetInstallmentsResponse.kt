package com.manuflowers.culqiservices.network.entities.response

import com.google.gson.annotations.SerializedName

data class GetInstallmentsResponse(
    @SerializedName("object")
    val `object`: String,
    @SerializedName("bin")
    val bin: String,
    @SerializedName("card_brand")
    val card_brand: String,
    @SerializedName("card_type")
    val card_type: Any,
    @SerializedName("card_category")
    val card_category: String,
    @SerializedName("issuer")
    val issuer: Issuer,
    @SerializedName("installments_allowed")
    val installments_allowed: List<Int>
)