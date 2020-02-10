package com.manuflowers.paymentsculqi.network.authorization

import com.manuflowers.paymentsculqi.network.entities.response.GetTokenResponse

interface AuthCallback {

    fun onSuccess(getTokenResponse: GetTokenResponse)

    fun onError(errorMessage: String)

}