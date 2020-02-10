package com.manuflowers.culqipayments

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.linear_layout_card_form.view.*

class CardFormLinearLayout(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {

    init {
        View.inflate(context, R.layout.linear_layout_card_form, this)
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.CardFormLinearLayout,
            0,
            0
        ).apply {
            try {
            } finally {
                recycle()
            }
        }
    }

    private fun validateIfIsValidCard(cardNumber: String) {

        val visaPattern = "^4[0-9]{12}(?:[0-9]{3})?$".toRegex()

        val masterCardPattern =
            "/^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$/".toRegex()

        val amexPattern = "/^3[47][0-9]{13}\$/".toRegex()

        val dinnersPattern =
            "/(^3(?:0[0-5]|[68][0-9])[0-9]{11}\$)|(^6(?:011|5[0-9]{2})[0-9]{12}\$)/".toRegex()

        val cardNumber2 =
            "/(^4[0-9]{12}(?:[0-9]{3})?\$)|(^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}\$)|(^3[47][0-9]{13}\$)|(^3(?:0[0-5]|[68][0-9])[0-9]{11}\$)|(^6(?:011|5[0-9]{2})[0-9]{12}\$)/".toRegex()


        if (visaPattern.matches(cardNumber)) {
            Log.e("EMAIL", "$cardNumber matches")
        }
    }

    fun getCardNumberValue() {
        ownerNameEditText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validateIfIsValidCard(cardNumberEditText.text.toString())
            }

        }

    }

}