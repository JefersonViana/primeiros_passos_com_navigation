package com.example.primeiros_passos_com_navigation.extensions

import com.google.android.material.textfield.TextInputLayout

var TextInputLayout.text: String
    get() = editText?.text.toString() ?: ""
    set(value) {
        editText?.setText(value)
    }