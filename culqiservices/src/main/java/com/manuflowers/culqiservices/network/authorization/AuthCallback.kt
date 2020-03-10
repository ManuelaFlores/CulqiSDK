package com.manuflowers.culqiservices.network.authorization

import com.manuflowers.culqiservices.network.entities.response.GetTokenResponse

interface AuthCallback {

    fun onSuccess(getTokenResponse: GetTokenResponse)

    fun onFailure(userErrorMessage: String?)

    fun onError(errorMessage: String?)

}