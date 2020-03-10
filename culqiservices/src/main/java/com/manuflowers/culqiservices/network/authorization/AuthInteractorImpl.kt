package com.manuflowers.culqiservices.network.authorization

import com.manuflowers.culqiservices.network.CulqiApiManager
import com.manuflowers.culqiservices.network.entities.request.GetTokenEntity
import com.manuflowers.culqiservices.network.entities.response.GetTokenResponse
import com.manuflowers.culqiservices.utils.GetTokenErrorUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthInteractorImpl : AuthInteractor {


    override fun getToken(
        getTokenEntity: GetTokenEntity,
        onAuthCallback: AuthCallback,
        privateKey: String
    ) {

        CulqiApiManager.secureCulqiClient.getToken(
            "Bearer $privateKey",
            getTokenEntity
        ).enqueue(object : Callback<GetTokenResponse> {

            override fun onResponse(
                call: Call<GetTokenResponse>,
                response: Response<GetTokenResponse>
            ) {
                if (response.code() == 201 && response.body() != null) {
                    onAuthCallback.onSuccess(response.body()!!)
                } else {
                    val userMessage = GetTokenErrorUtil().parseError(response).userMessage
                    onAuthCallback.onFailure(userMessage ?: "Por favor, verifique que los detalles de pago sean correctos, o seleccione un método de pago distinto")
                }
            }

            override fun onFailure(call: Call<GetTokenResponse>, t: Throwable) {
                onAuthCallback.onError(
                    t.localizedMessage ?: "Método de pago no disponible en estos momentos"
                )
            }

        })
    }

}