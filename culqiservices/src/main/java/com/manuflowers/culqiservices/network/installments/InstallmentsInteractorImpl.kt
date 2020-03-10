package com.manuflowers.culqiservices.network.installments

import com.manuflowers.culqiservices.network.entities.request.GetInstallmentsEntity
import com.manuflowers.culqiservices.network.CulqiApiManager
import com.manuflowers.culqiservices.network.entities.response.GetInstallmentsResponse
import com.manuflowers.culqiservices.utils.InstallmentsErrorUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InstallmentsInteractorImpl : InstallmentsInteractor {
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
                if (response.code() == 200 && response.body() != null) {
                    installmentsCallback.onSuccess(response.body()!!)
                } else {
                    val userMessage = InstallmentsErrorUtil().parseInstallmentsError(response).userMessage
                    installmentsCallback.onFailure(userMessage)
                }
            }

            override fun onFailure(call: Call<GetInstallmentsResponse>, t: Throwable) {
                installmentsCallback.onError("Por el momento no podemos procesar pagos en cuotas")
            }
        })
    }
}