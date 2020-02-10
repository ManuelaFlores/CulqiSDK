package com.manuflowers.paymentsculqi

import com.manuflowers.paymentsculqi.network.authorization.AuthInteractorImpl
import com.manuflowers.paymentsculqi.network.authorization.AuthCallback
import com.manuflowers.paymentsculqi.network.entities.request.GetTokenEntity

class CulqiSdk {

    fun generateToken(
        getTokenEntity: GetTokenEntity,
        onAuthCallback: AuthCallback
    ) {
        return AuthInteractorImpl().getToken(
           getTokenEntity ,
            onAuthCallback
        )
    }
}