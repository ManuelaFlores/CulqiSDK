package com.manuflowers.paymentsculqi.network.authorization

import com.manuflowers.paymentsculqi.network.entities.request.GetTokenEntity

interface AuthInteractor {

    fun getToken(
        getTokenEntity: GetTokenEntity,
        onAuthCallback: AuthCallback
    )
}