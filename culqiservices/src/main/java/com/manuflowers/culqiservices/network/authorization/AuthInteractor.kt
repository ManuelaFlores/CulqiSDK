package com.manuflowers.culqiservices.network.authorization

import com.manuflowers.culqiservices.network.entities.request.GetTokenEntity
import com.manuflowers.culqiservices.network.authorization.AuthCallback

interface AuthInteractor {

    fun getToken(
        getTokenEntity: GetTokenEntity,
        onAuthCallback: AuthCallback,
        privateKey: String
    )
}