package com.manuflowers.culqipayments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.manuflowers.culqiservices.CulqiSdk
import com.manuflowers.culqiservices.network.authorization.AuthCallback
import com.manuflowers.culqiservices.network.entities.request.GetInstallmentsEntity
import com.manuflowers.culqiservices.network.entities.request.GetTokenEntity
import com.manuflowers.culqiservices.network.entities.request.Metadata
import com.manuflowers.culqiservices.network.entities.response.GetInstallmentsResponse
import com.manuflowers.culqiservices.network.entities.response.GetTokenResponse
import com.manuflowers.culqiservices.network.installments.InstallmentsCallback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateToken()
        getInstallments()
    }

    private fun getInstallments() {
        val installmentsEntity = GetInstallmentsEntity
            .Builder()
            .bin("411111")
            .build()

        CulqiSdk().getInstallments(
            "TOKEN",
            installmentsEntity,
            object : InstallmentsCallback {
                override fun onSuccess(getInstallmentsResponse: GetInstallmentsResponse) {
                    Log.e("RESPONSE-S", "$getInstallmentsResponse")
                }

                override fun onFailure(userErrorMessage: String?) {
                    Log.e("RESPONSE-F", "$userErrorMessage")
                }

                override fun onError(errorMessage: String?) {
                    Log.e("RESPONSE-E", "$errorMessage")
                }

            }
        )
    }

    private fun generateToken() {

        val metadata = Metadata
            .Builder()
            .accountHolderName("prueba")
            .accountHolderLastName("ggggg")
            .build()

        val card = GetTokenEntity
            .Builder()
            .card(
                cardNumber = "4111111111111111",
                cvv = "123",
                expirationMonth = "09",
                expirationYear = "2025",
                email = "prueba@gmail.com",
                metadata = metadata
            ).build()

        CulqiSdk().generateToken(
            "pk_test_BcnPaY5POsvYI09T",
            card,
            object : AuthCallback {
                override fun onSuccess(getTokenResponse: GetTokenResponse) {
                    Log.e("SUCCESS", "$getTokenResponse")
                }

                override fun onFailure(userErrorMessage: String?) {
                    Log.e("ERROR", userErrorMessage ?: "")
                }

                override fun onError(errorMessage: String?) {
                    Log.e("ERROR", errorMessage ?: "")
                }
            }
        )
    }
}

/**
 *
 * "4111111111111111",
"123",
"09",
"2020",
"fmanuela499@gmail.com",
"MANUELA FLORES",
 *
 * {
"card_number": "4111111111111111",
"cvv": "123",
"expiration_month": "09",
"expiration_year": "2020",
"email": ""
}
 * */

/***
 * {
 * "object":"iin",
 * "bin":"411111",
 * "card_brand":"Visa",
 * "card_type":"credito",
 * "card_category":"Clásica",
 * "issuer":{"name":"BBVA",
 * "country":"PERU",
 * "country_code":"PE",
 * "website":null,
 * "phone_number":null
 * },
 * "installments_allowed":[2,4,6,8,10,12,3,5,7,9,24,48]}
 * */