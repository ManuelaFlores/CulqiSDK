package com.manuflowers.culqiservices.network.installments

import com.manuflowers.culqiservices.network.entities.response.GetInstallmentsResponse

interface InstallmentsCallback {

    fun onSuccess(getInstallmentsResponse: GetInstallmentsResponse)

    fun onFailure(userErrorMessage: String?)

    fun onError(errorMessage: String?)

}