package com.manuflowers.paymentsculqi.network.authorization

interface AuthListener {

    fun onSuccess(token: String)

    fun onError(errorMessage: String)

}