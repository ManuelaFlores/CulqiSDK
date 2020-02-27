package com.manuflowers.paymentsculqi.network.authorization

import com.manuflowers.paymentsculqi.network.entities.response.GetInstallmentsResponse

interface InstallmentsCallback {

    fun onSuccess(getInstallmentsResponse: GetInstallmentsResponse)

    fun onFailure(userErrorMessage: String?)

    fun onError(errorMessage: String?)

}