package com.manuflowers.paymentsculqi.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        var retrofitClient: CulqiApi =
            getRetrofit("https://secure.culqi.com/v2/").create(CulqiApi::class.java)

        private fun getRetrofit(domain: String): Retrofit {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .build()

            return Retrofit.Builder()
                .baseUrl(domain)
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