package com.manuflowers.paymentsculqi.utils

import com.manuflowers.paymentsculqi.network.CulqiApiManager
import com.manuflowers.paymentsculqi.network.entities.response.ErrorModel
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

class ErrorUtils {

    fun parseError(response: Response<*>): ErrorModel {
        val converter: Converter<ResponseBody, ErrorModel> = CulqiApiManager.getRetrofit().responseBodyConverter(
            ErrorModel::class.java,
            arrayOfNulls<Annotation>(0)
        )

        val error: ErrorModel

        try {
            error = converter.convert(response.errorBody()!!)!!
        } catch (e: IOException) {
            return ErrorModel("","","","","","Error al obtener token")
        }

        return error
    }
}