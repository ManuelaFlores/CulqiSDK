package com.manuflowers.paymentsculqi.utils

import com.manuflowers.paymentsculqi.network.CulqiApiManager
import com.manuflowers.paymentsculqi.network.entities.request.ApiError
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException


object ErrorUtils {

    fun parseError(response: Response<*>): ApiError {
        val converter: Converter<ResponseBody, ApiError> = CulqiApiManager.getRetrofit().responseBodyConverter(
            ApiError::class.java,
            arrayOfNulls<Annotation>(0)
        )

        val error: ApiError

        try {
            error = converter.convert(response.errorBody()!!)!!
        } catch (e: IOException) {
            return ApiError()
        }

        return error
    }
}