package com.manuflowers.culqiservices.network.installments

import com.manuflowers.culqiservices.network.entities.request.GetInstallmentsEntity
import com.manuflowers.culqiservices.network.CulqiApiManager
import com.manuflowers.culqiservices.network.entities.response.GetInstallmentsResponse
import com.manuflowers.culqiservices.network.entities.response.Issuer
import com.manuflowers.culqiservices.utils.InstallmentsErrorUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class  InstallmentsInteractorImpl : InstallmentsInteractor {
    override fun getInstallments(
        getInstallmentsEntity: GetInstallmentsEntity,
        privateKey: String,
        installmentsCallback: InstallmentsCallback
    ) {
        CulqiApiManager.culqiClient.getInstallments(
            "Bearer $privateKey",
            getInstallmentsEntity.bin
        ).enqueue(object : Callback<GetInstallmentsResponse> {
            override fun onResponse(
                call: Call<GetInstallmentsResponse>,
                response: Response<GetInstallmentsResponse>
            ) {
                val messageError =
                    "Por favor verifique que los detalles de pago sean correctos, o seleccione un método de pago distinto"

                when (response.code()) {
                    200 -> {
                        if (response.body() != null) {
                            installmentsCallback.onSuccess(
                                response.body() ?: GetInstallmentsResponse(
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    Issuer("", "", "", "", 0),
                                    installments_allowed = listOf()
                                )
                            )
                        }
                    }
                    400 -> {
                        val userMessage =
                            InstallmentsErrorUtil().parseInstallmentsError(response).userMessage
                        installmentsCallback.onFailure(userMessage)
                    }
                    401, 402, 403, 404, 422 -> {
                        installmentsCallback.onFailure(messageError)
                    }
                    500, 503, 504 -> {
                        //Error en los servidores de culqi y la peticion no pudo ser procesada
                        installmentsCallback.onFailure(messageError)
                    }
                    else -> {
                        installmentsCallback.onFailure(messageError)
                    }
                }
                /*if (response.code() == 200 && response.body() != null) {
                    installmentsCallback.onSuccess(response.body()!!)
                } else {
                    val userMessage = InstallmentsErrorUtil().parseInstallmentsError(response).userMessage
                    installmentsCallback.onFailure(userMessage)
                }*/
            }

            override fun onFailure(call: Call<GetInstallmentsResponse>, t: Throwable) {
                installmentsCallback.onError("Por el momento no podemos procesar pagos en cuotas")
            }
        })
    }
}