package com.manuflowers.paymentsculqi.network

import com.manuflowers.paymentsculqi.network.entities.response.GetTokenResponse
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST

interface CulqiApi {

    @Headers(
        "Content-type: application/json", "authorization: Bearer pk_test_mho9TZvUHPATDCSi"
    )
    @POST("tokens")
    fun getToken(
        carNumber: String,
        ccv: String,
        expirationMonth: String,
        expirationYear: String,
        email: String
    ): Call<GetTokenResponse>

}