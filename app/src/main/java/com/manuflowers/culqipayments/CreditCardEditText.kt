package com.manuflowers.culqipayments

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatEditText
import kotlinx.android.synthetic.main.linear_layout_card_form.view.*


class CreditCardEditText(context: Context, attributeSet: AttributeSet) :
    AppCompatEditText(context, attributeSet) {

    /*init {
        View.inflate(context, R.layout.view_credit_card_edit_text,null)
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.CreditCardEditText,
            0,
            0
        ).apply {
            try {
            } finally {
                recycle()
            }
        }
    }*/

    /*override fun addTextChangedListener(watcher: TextWatcher?) {
        super.addTextChangedListener(watcher)

        doAfterTextChanged { editable ->
            Log.e("PRUEBA--", "$editable")
            if (editable.length() > 0 && s.length() % 5 === 0) {
                val c = s.charAt(s.length() - 1)
                // Only if its a digit where there should be a space we insert a space
                if (Character.isDigit(c) && TextUtils.split(
                        s.toString(),
                        String.valueOf(space)
                    ).size <= 3
                ) {
                    s.insert(s.length() - 1, String.valueOf(space))
                }
            }
        }
    }*/

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        //These are the card types that we support:


    }


}

