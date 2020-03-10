package com.manuflowers.culqiservices.network.entities.response

import com.google.gson.annotations.SerializedName

data class InstallmentsErrorModel(
    @SerializedName("merchant_message")
    val merchantMessage: String,
    @SerializedName("object")
    val objectX: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("user_message")
    val userMessage: String
)