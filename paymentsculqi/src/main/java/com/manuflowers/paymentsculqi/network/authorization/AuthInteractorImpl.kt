package com.manuflowers.paymentsculqi.network.authorization

import com.manuflowers.paymentsculqi.network.CulqiApiManager
import com.manuflowers.paymentsculqi.network.entities.request.GetTokenEntity
import com.manuflowers.paymentsculqi.network.entities.response.GetTokenResponse
import com.manuflowers.paymentsculqi.utils.ErrorUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthInteractorImpl : AuthInteractor {


    override fun getToken(
        getTokenEntity: GetTokenEntity,
        onAuthCallback: AuthCallback,
        privateKey: String
    ) {

        CulqiApiManager.retrofitClient.getToken(
            "Bearer $privateKey",
            getTokenEntity
        ).enqueue(object : Callback<GetTokenResponse> {

            override fun onResponse(
                call: Call<GetTokenResponse>,
                response: Response<GetTokenResponse>
            ) {
                if (response.code() == 201 && response.errorBody() != null) {
                    onAuthCallback.onSuccess(response.body()!!)
                } else {
                   val userMessage =  ErrorUtils().parseError(response).merchantMessage
                    print(userMessage)
                    //onAuthCallback.onError(userMessage)
                }
            }

            override fun onFailure(call: Call<GetTokenResponse>, t: Throwable) {
                onAuthCallback.onError("Método de pago no disponible en estos momentos")
            }

        })
    }

}