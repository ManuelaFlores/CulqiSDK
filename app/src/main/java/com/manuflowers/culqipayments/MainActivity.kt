package com.manuflowers.culqipayments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.manuflowers.paymentsculqi.CulqiSdk
import com.manuflowers.paymentsculqi.network.authorization.AuthCallback
import com.manuflowers.paymentsculqi.network.entities.request.GetInstallmentsEntity
import com.manuflowers.paymentsculqi.network.entities.request.GetTokenEntity
import com.manuflowers.paymentsculqi.network.entities.request.Metadata
import com.manuflowers.paymentsculqi.network.entities.response.GetInstallmentsResponse
import com.manuflowers.paymentsculqi.network.entities.response.GetTokenResponse
import com.manuflowers.paymentsculqi.network.installments.InstallmentsCallback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateToken()
        //getInstallments()
    }

    //4557880527876407

    private fun getInstallments() {
        val installmentsEntity = GetInstallmentsEntity
            .Builder()
            .bin("411111")
            .build()
        //pk_test_BcnPaY5POsvYI09T

        CulqiSdk().getInstallments(
            "pk_test_BcnPaY5POsvYI09T",
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
            .accountHolderName("manuel")
            .accountHolderLastName("ggggg")
            .build()

        val card = GetTokenEntity
            .Builder()
            .card(
                cardNumber = "36000200000006",
                cvv = "230",
                expirationMonth = "01",
                expirationYear = "2020",
                email = "fmanuela499@gmail.com",
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