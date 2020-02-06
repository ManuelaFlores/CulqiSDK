package com.manuflowers.paymentsculqi.network.authorization

interface AuthInteractor {

    fun getToken(
        carNumber: String,
        ccv: String,
        expirationMonth: String,
        expirationYear: String,
        email: String,
        onAuthListener: AuthListener
    )
}