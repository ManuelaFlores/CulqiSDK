package com.manuflowers.culqipayments

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.linear_layout_card_form.view.*

class CardFormLinearLayout(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {

    val visaPattern = "^4[0-9]{12}(?:[0-9]{3})?$".toRegex()

    val dinnersPattern =
        "(^3(?:0[0-5]|[68][0-9])[0-9]{11}\$)|(^6(?:011|5[0-9]{2})[0-9]{12}\$)".toRegex()

    val amexPattern = "^3[47][0-9]{13}\$".toRegex()

    val masterCardPattern =
        "^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$".toRegex()

    private val isValidCreditCard =
        "(^4[0-9]{12}(?:[0-9]{3})?\$)|(^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}\$)|(^3[47][0-9]{13}\$)|(^3(?:0[0-5]|[68][0-9])[0-9]{11}\$)|(^6(?:011|5[0-9]{2})[0-9]{12}\$)".toRegex()

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
        validateIfIsValidCard()
        setupExpirationDate()
    }

    private fun validateIfIsValidCard() {
        creditCardEditText.addTextChangedListener(
            AutoAddTextWatcher2(
                creditCardEditText,
                " ",
                object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {

                        text.let {
                            if (text!!.isNotEmpty()) {
                                val currentText = text.toString().filter { it != ' ' }
                                when {

                                    visaPattern.matches(currentText) -> {
                                        currentTypeCard.setImageResource(R.drawable.ic_visa)
                                    }
                                    dinnersPattern.matches(currentText) -> {
                                        currentTypeCard.setImageResource(R.drawable.ic_dinners)
                                    }
                                    amexPattern.matches(currentText) -> {
                                        currentTypeCard.setImageResource(R.drawable.ic_american_express)
                                    }
                                    masterCardPattern.matches(currentText) -> {
                                        currentTypeCard.setImageResource(R.drawable.ic_mastercard)
                                    }
                                }
                            }
                        }

                    }

                    override fun afterTextChanged(p0: Editable?) {}

                },
                4,
                8,
                12
            )
        )

        creditCardEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                if (!isValidCreditCard.matches(creditCardEditText.text.toString().filter { it != ' ' })) {
                    creditCartTextInputLayout.error = "Tarjeta inválida"
                }
            }
        }
    }

    private fun setupExpirationDate() {

        expirationDateEditText.addTextChangedListener(
            AutoAddTextWatcher2(
                expirationDateEditText,
                "/",
                2
            )
        )

        expirationDateEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {

                if (expirationDateEditText.text.toString().length == 5) {

                    val monthValue = expirationDateEditText.text.toString().substring(0, 2)
                    val yearValue = expirationDateEditText.text.toString().substring(3, 5)

                    if ((monthValue.toInt() !in (1..12) || yearValue.toInt() <= 20)) {
                        expirationDateTextInputLayout.error = "Complete este campo obligatorio"
                    }
                }

                if (expirationDateEditText.text.toString().isEmpty() || expirationDateEditText.text.toString().length != 5) {
                    expirationDateTextInputLayout.error = "Complete este campo obligatorio"
                }
            }
        }
    }

}