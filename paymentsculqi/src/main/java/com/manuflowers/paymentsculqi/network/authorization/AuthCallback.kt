package com.manuflowers.paymentsculqi.network.authorization

interface AuthCallback {

    fun onSuccess(token: String)

    fun onError(errorMessage: String)

}