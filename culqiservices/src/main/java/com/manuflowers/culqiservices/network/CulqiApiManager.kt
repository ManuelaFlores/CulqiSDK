package com.manuflowers.culqiservices.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.manuflowers.culqiservices.network.CulqiApi
import com.manuflowers.culqiservices.network.SecureCulqiApi

/**
 * @Class CulqiApiManager is in charge of manage every instance related with retrofit client
 * */
class CulqiApiManager {

    /**
     * Companion is the same as use static keyword
     * */
    companion object {

        /**
         * @Volatile : keyword  used to modify the value of a variable by different threads;
         *  that means volatile keyword is always read from the main memory,
         *  it cannot be used n classes or methods
         * */
        @Volatile
        var secureCulqiClient: CulqiApi =
            getRetrofit("https://secure.culqi.com/v2/").create(CulqiApi::class.java)

        @Volatile
        var culqiClient: SecureCulqiApi = getRetrofit("https://api.culqi.com/v2/").create(
            SecureCulqiApi::class.java)



        @JvmStatic
        fun getRetrofit(baseUrl: String): Retrofit {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getInterceptor(): HttpLoggingInterceptor {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return loggingInterceptor
        }
    }

}