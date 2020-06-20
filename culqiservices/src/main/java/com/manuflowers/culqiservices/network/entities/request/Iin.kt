package com.manuflowers.culqiservices.network.entities.request


import com.google.gson.annotations.SerializedName
import com.manuflowers.culqiservices.network.entities.response.Issuer

data class Iin(
    @SerializedName("bin")
    val bin: String,
    @SerializedName("card_brand")
    val cardBrand: String,
    @SerializedName("card_category")
    val cardCategory: String,
    @SerializedName("card_type")
    val cardType: String,
    @SerializedName("installments_allowed")
    val installmentsAllowed: List<Int>,
    @SerializedName("issuer")
    val issuer: Issuer,
    @SerializedName("object")
    val objectX: String
)