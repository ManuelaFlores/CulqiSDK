package com.manuflowers.culqiservices.utils

import com.manuflowers.culqiservices.network.CulqiApiManager
import com.manuflowers.culqiservices.network.entities.response.ErrorModel
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

class GetTokenErrorUtil {

    fun parseError(response: Response<*>): ErrorModel {
        val converter: Converter<ResponseBody, ErrorModel> =
            CulqiApiManager.getRetrofit("https://secure.culqi.com/v2/").responseBodyConverter(
                ErrorModel::class.java,
                arrayOfNulls<Annotation>(0)
            )

        val error: ErrorModel

        try {
            error = converter.convert(response.errorBody()!!)!!
        } catch (e: IOException) {
            return ErrorModel("", "", "", "", "", "Error al obtener token")
        }

        return error
    }

}