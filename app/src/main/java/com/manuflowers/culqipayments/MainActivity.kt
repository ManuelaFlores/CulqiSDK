package com.manuflowers.culqipayments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.manuflowers.paymentsculqi.CulqiSdk
import com.manuflowers.paymentsculqi.network.authorization.AuthListener
import com.manuflowers.paymentsculqi.network.entities.request.Metadata

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateToken()
    }

    private fun generateToken() {

        CulqiSdk().generateToken(
            "4111111111111111",
            "123",
            "09",
            "2020",
            "fmanuela499@gmail.com",
            ""
            object : AuthListener {
                override fun onSuccess(token: String) {
                    Log.e("SUCCESS", token)
                }

                override fun onError(errorMessage: String) {
                    Log.e("ERROR", errorMessage)
                }

            }
        )
    }
}

/**
 * {
"card_number": "4111111111111111",
"cvv": "123",
"expiration_month": "09",
"expiration_year": "2020",
"email": ""
}
 * */