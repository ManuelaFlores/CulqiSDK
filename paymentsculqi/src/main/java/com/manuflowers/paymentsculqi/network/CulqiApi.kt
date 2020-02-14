package com.manuflowers.paymentsculqi.network

import com.manuflowers.paymentsculqi.network.entities.request.GetTokenEntity
import com.manuflowers.paymentsculqi.network.entities.response.GetTokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface CulqiApi {

    /*@Headers(
        "Content-type: application/json", "authorization: Bearer pk_test_mho9TZvUHPATDCSi"
    )*/
    @POST("tokens")
    fun getToken(
        @Header("authorization") authorization: String,
        @Body tokenRequestEntity: GetTokenEntity
    ): Call<GetTokenResponse>

}