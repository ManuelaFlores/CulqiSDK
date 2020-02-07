package com.manuflowers.paymentsculqi

import com.manuflowers.paymentsculqi.network.authorization.AuthInteractorImpl
import com.manuflowers.paymentsculqi.network.authorization.AuthCallback
import com.manuflowers.paymentsculqi.network.entities.request.Metadata

class CulqiSdk {

    fun generateToken(
        carNumber: String,
        ccv: String,
        expirationMonth: String,
        expirationYear: String,
        email: String,
        metada: Metadata,
        onAuthCallback: AuthCallback
    ) {
        return AuthInteractorImpl().getToken(
            carNumber,
            ccv,
            expirationMonth,
            expirationYear,
            email,
            metada,
            onAuthCallback
        )
    }
}