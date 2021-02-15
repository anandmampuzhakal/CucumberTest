package com.nz.anand.mvvmlibrary.adapter

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */
object ImageViewAdapter {

    @JvmStatic
    @BindingAdapter("bitmap")
    fun setBitmap(iv: ImageView, bitmap: Bitmap?) {
        iv.setImageBitmap(bitmap)
    }
}