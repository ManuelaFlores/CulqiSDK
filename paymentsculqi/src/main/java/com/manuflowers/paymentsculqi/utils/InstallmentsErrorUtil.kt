package com.manuflowers.paymentsculqi.utils

import com.manuflowers.paymentsculqi.network.CulqiApiManager
import com.manuflowers.paymentsculqi.network.entities.response.InstallmentsErrorModel
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

class InstallmentsErrorUtil {
    fun parseInstallmentsError(response: Response<*>): InstallmentsErrorModel {
        val converter: Converter<ResponseBody, InstallmentsErrorModel> =
            CulqiApiManager.getRetrofit("https://api.culqi.com/v2/").responseBodyConverter(
                InstallmentsErrorModel::class.java,
                arrayOfNulls<Annotation>(0)
            )

        val error: InstallmentsErrorModel

        try {
            error = converter.convert(response.errorBody()!!)!!
        } catch (e: IOException) {
            return InstallmentsErrorModel("", "", "", "Por el momento no podemos procesar pagos en cuotas")
        }
        return error
    }
}