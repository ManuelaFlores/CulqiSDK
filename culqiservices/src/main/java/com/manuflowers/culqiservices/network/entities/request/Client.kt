package com.manuflowers.culqiservices.network.entities.request


import com.google.gson.annotations.SerializedName

data class Client(
    @SerializedName("browser")
    val browser: String,
    @SerializedName("device_fingerprint")
    val deviceFingerprint: Any,
    @SerializedName("device_type")
    val deviceType: String,
    @SerializedName("ip")
    val ip: String,
    @SerializedName("ip_country")
    val ipCountry: String,
    @SerializedName("ip_country_code")
    val ipCountryCode: String
)