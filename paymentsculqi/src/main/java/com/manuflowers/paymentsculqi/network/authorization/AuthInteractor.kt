package com.manuflowers.paymentsculqi.network.authorization

import com.manuflowers.paymentsculqi.network.entities.request.Metadata

interface AuthInteractor {

    fun getToken(
        carNumber: String,
        ccv: String,
        expirationMonth: String,
        expirationYear: String,
        email: String,
        metadata: Metadata,
        onAuthCallback: AuthCallback
    )
}