package com.manuflowers.culqiservices

import com.manuflowers.culqiservices.network.authorization.AuthInteractorImpl
import com.manuflowers.culqiservices.network.authorization.AuthCallback
import com.manuflowers.culqiservices.network.entities.request.GetInstallmentsEntity
import com.manuflowers.culqiservices.network.entities.request.GetTokenEntity
import com.manuflowers.culqiservices.network.installments.InstallmentsCallback
import com.manuflowers.culqiservices.network.installments.InstallmentsInteractorImpl

class CulqiSdk {

    fun generateToken(
        privateKey: String,
        getTokenEntity: GetTokenEntity,
        onAuthCallback: AuthCallback
    ) {
        return AuthInteractorImpl().getToken(
            privateKey = privateKey,
            getTokenEntity = getTokenEntity,
            onAuthCallback = onAuthCallback
        )
    }

    fun getInstallments(
        privateKey: String,
        getInstallmentsEntity: GetInstallmentsEntity,
        installmentsCallback: InstallmentsCallback
    ) {
        return InstallmentsInteractorImpl().getInstallments(
            privateKey = privateKey,
            getInstallmentsEntity = getInstallmentsEntity,
            installmentsCallback = installmentsCallback
        )
    }
}