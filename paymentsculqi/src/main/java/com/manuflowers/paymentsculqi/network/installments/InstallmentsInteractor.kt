package com.manuflowers.paymentsculqi.network.installments

import com.manuflowers.paymentsculqi.network.entities.request.GetInstallmentsEntity
import java.security.PrivateKey

interface InstallmentsInteractor {

    fun getInstallments(
        getInstallmentsEntity: GetInstallmentsEntity,
        privateKey: String,
        installmentsCallback: InstallmentsCallback
    )
}