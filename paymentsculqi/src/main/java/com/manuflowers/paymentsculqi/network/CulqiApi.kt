package com.manuflowers.paymentsculqi.network

import com.manuflowers.paymentsculqi.network.entities.request.GetTokenEntity
import com.manuflowers.paymentsculqi.network.entities.request.InstallmentsEntity
import com.manuflowers.paymentsculqi.network.entities.response.GetInstallmentsResponse
import com.manuflowers.paymentsculqi.network.entities.response.GetTokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface CulqiApi {

    @POST("tokens")
    fun getToken(
        @Header("authorization") authorization: String,
        @Body tokenRequestEntity: GetTokenEntity
    ): Call<GetTokenResponse>

    @GET("iins")
    fun getInstallments(
        @Header("authorization") authorization: String,
        @Body installmentsEntity: InstallmentsEntity
    ): Call<GetInstallmentsResponse>

}