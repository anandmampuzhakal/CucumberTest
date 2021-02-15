package com.nz.anand.mvvmlibrary.extension

import android.content.Context
import android.widget.Toast
/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */
fun Context.showToast(text: String?) {
    text ?: return
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}