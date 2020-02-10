package com.manuflowers.paymentsculqi.network.authorization

import com.manuflowers.paymentsculqi.network.CulqiApiManager
import com.manuflowers.paymentsculqi.network.entities.request.GetTokenEntity
import com.manuflowers.paymentsculqi.network.entities.request.Metadata
import com.manuflowers.paymentsculqi.network.entities.response.GetTokenResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthInteractorImpl : AuthInteractor {


    override fun getToken(
        getTokenEntity: GetTokenEntity,
        onAuthCallback: AuthCallback
    ) {

        CulqiApiManager.retrofitClient.getToken(
            getTokenEntity
        ).enqueue(object : Callback<GetTokenResponse> {

            override fun onResponse(
                call: Call<GetTokenResponse>,
                response: Response<GetTokenResponse>
            ) {
                if (response.code() == 201 && response.body() != null) {
                    // llenar aqui getTokenResponse
                    print("FROM_SDK: ${response.body()}")
                    onAuthCallback.onSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<GetTokenResponse>, t: Throwable) {
                onAuthCallback.onError(t.localizedMessage)
            }

        })
    }

}