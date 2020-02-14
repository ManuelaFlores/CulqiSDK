package com.manuflowers.culqipayments

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlin.math.min


class AutoAddTextWatcher2(
    private val mEditText: EditText,
    private val mAppentText: String,
    vararg position: Int
) : TextWatcher {
    private var mBeforeTextChanged: CharSequence? = null
    private var mTextWatcher: TextWatcher? = null
    private val mArray_pos: IntArray = position.clone()

    constructor(
        editText: EditText,
        appendText: String,
        textWatcher: TextWatcher,
        vararg position: Int
    ) : this(editText, appendText, *position) {
        this.mTextWatcher = textWatcher
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        mBeforeTextChanged = s.toString()

        mTextWatcher?.beforeTextChanged(s, start, count, after)

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        for (i in mArray_pos.indices) {
            if (mBeforeTextChanged!!.length - mAppentText.length * i == mArray_pos[i] - 1 && s.length - mAppentText.length * i == mArray_pos[i]) {
                mEditText.append(mAppentText)

                break
            }

            if (mBeforeTextChanged!!.length - mAppentText.length * i == mArray_pos[i] && s.length - mAppentText.length * i == mArray_pos[i] + 1) {
                val idx_start = mArray_pos[i] + mAppentText.length * i
                val idx_end = min(idx_start + mAppentText.length, s.length)

                val sub = mEditText.text.toString().substring(idx_start, idx_end)

                if (sub != mAppentText) {
                    mEditText.text.insert(s.length - 1, mAppentText)
                }

                break
            }

            if (mAppentText.length > 1 &&
                mBeforeTextChanged!!.length - mAppentText.length * i == mArray_pos[i] + mAppentText.length &&
                s.length - mAppentText.length * i == mArray_pos[i] + mAppentText.length - 1
            ) {
                val idx_start = mArray_pos[i] + mAppentText.length * i
                val idx_end = min(idx_start + mAppentText.length, s.length)

                mEditText.text.delete(idx_start, idx_end)

                break
            }

        }

        mTextWatcher?.onTextChanged(s, start, before, count)

    }

    override fun afterTextChanged(s: Editable) {
        mTextWatcher?.afterTextChanged(s)

    }

}