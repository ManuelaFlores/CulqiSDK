package com.manuflowers.culqiservices.network

import com.manuflowers.culqiservices.network.entities.request.GetTokenEntity
import com.manuflowers.culqiservices.network.entities.response.GetTokenResponse
import retrofit2.Call
import retrofit2.http.*

interface CulqiApi {

    @POST("tokens")
    fun getToken(
        @Header("authorization") authorization: String,
        @Body tokenRequestEntity: GetTokenEntity
    ): Call<GetTokenResponse>

}