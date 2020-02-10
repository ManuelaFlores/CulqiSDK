package com.manuflowers.culqipayments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.manuflowers.paymentsculqi.CulqiSdk
import com.manuflowers.paymentsculqi.network.authorization.AuthCallback
import com.manuflowers.paymentsculqi.network.entities.request.GetTokenEntity
import com.manuflowers.paymentsculqi.network.entities.request.Metadata
import com.manuflowers.paymentsculqi.network.entities.response.GetTokenResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateToken()
    }

    private fun generateToken() {

        val metadata = Metadata
            .Builder()
            .accountHolderName("MANUELA FLORES")
            .build()

        val card = GetTokenEntity
            .Builder()
            .card(
                cardNumber = "4111111111111111",
                cvv = "123",
                expirationMonth = "09",
                expirationYear = "2020",
                email = "fmanuela499@gmail.com",
                metadata = metadata
            ).build()

        CulqiSdk().generateToken(
            card,
            object : AuthCallback {
                override fun onSuccess(getTokenResponse: GetTokenResponse) {
                    Log.e("SUCCESS", "$getTokenResponse")

                }

                override fun onError(errorMessage: String) {
                    Log.e("ERROR", errorMessage)
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