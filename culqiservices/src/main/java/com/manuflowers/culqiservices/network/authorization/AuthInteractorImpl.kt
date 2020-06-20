package com.manuflowers.culqiservices.network.authorization

import com.manuflowers.culqiservices.network.CulqiApiManager
import com.manuflowers.culqiservices.network.entities.request.GetTokenEntity
import com.manuflowers.culqiservices.network.entities.request.Metadata
import com.manuflowers.culqiservices.network.entities.response.Client
import com.manuflowers.culqiservices.network.entities.response.GetTokenResponse
import com.manuflowers.culqiservices.network.entities.response.Iin
import com.manuflowers.culqiservices.network.entities.response.Issuer
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
                val messageError =
                    "Por favor verifique que los detalles de pago sean correctos, o seleccione un método de pago distinto"

                when (response.code()) {
                    201 -> {
                        if (response.body() != null) {
                            onAuthCallback.onSuccess(
                                response.body() ?: GetTokenResponse(
                                    "",
                                    "",
                                    "",
                                    0,
                                    "",
                                    "",
                                    "",
                                    false,
                                    Iin(
                                        "", "", "", "", "", Issuer("", "", "", "", ""),
                                        listOf()
                                    ),
                                    Client("", "", "", "", "", ""),
                                    Metadata("", "")
                                )
                            )
                        }
                    }
                    400,401, 402, 403, 404, 422 -> {
                        val userMessage =
                            GetTokenErrorUtil().parseError(response).userMessage
                        onAuthCallback.onFailure(userMessage ?: "Por favor, verifique que los detalles de pago sean correctos, o seleccione un método de pago distinto")
                    }
                    500, 503, 504 -> {
                        //Error en los servidores de culqi y la peticion no pudo ser procesada
                        onAuthCallback.onFailure(messageError)
                    }
                    else -> {
                        onAuthCallback.onFailure(messageError)
                    }
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