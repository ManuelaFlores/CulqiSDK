package com.manuflowers.culqiservices.network.installments

import com.manuflowers.culqiservices.network.entities.request.GetInstallmentsEntity
import com.manuflowers.culqiservices.network.installments.InstallmentsCallback

interface InstallmentsInteractor {

    fun getInstallments(
        getInstallmentsEntity: GetInstallmentsEntity,
        privateKey: String,
        installmentsCallback: InstallmentsCallback
    )
}