package com.manuflowers.paymentsculqi.network.installments

import com.manuflowers.paymentsculqi.network.entities.response.GetInstallmentsResponse

interface InstallmentsCallback {

    fun onSuccess(getInstallmentsResponse: GetInstallmentsResponse)

    fun onFailure(userErrorMessage: String?)

    fun onError(errorMessage: String?)

}