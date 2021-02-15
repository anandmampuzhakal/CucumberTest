package com.nz.anand.mvvmlibrary.mvvm

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nz.anand.mvvmlibrary.extension.bindBaseLiveData
/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */
class MVVMViewModelFactory(private val context: Context, private val lifecycle: Lifecycle) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val clazz = modelClass.newInstance()
        if (clazz is MVVMBaseViewModel) {
            lifecycle.addObserver(clazz)
            if (context is MVVMBaseActivity) {
                context.bindBaseLiveData(clazz)
                clazz.bundle = context.intent.extras ?: Bundle()
            } else if (context is MVVMBaseFragment) {
                context.bindBaseLiveData(clazz)
                clazz.bundle = context.arguments ?: Bundle()
            }
        }
        return clazz
    }
}