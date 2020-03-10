package com.manuflowers.culqiservices.network

import com.manuflowers.culqiservices.network.entities.response.GetInstallmentsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface SecureCulqiApi {

    @GET("iins/{bin}")
    fun getInstallments(
        @Header("Authorization") authorization: String,
        @Path("bin") bin: String
    ): Call<GetInstallmentsResponse>

}