package com.nz.anand.mvvmlibrary.mvvm

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */
abstract class MVVMBaseActivity(@LayoutRes val layoutId: Int) : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutId != 0) {
            DataBindingUtil.setContentView<ViewDataBinding>(this, layoutId)
        }
    }

}