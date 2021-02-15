package com.nz.anand.mvvmlibrary.mvvm

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.nz.anand.mvvmlibrary.livedata.SingleLiveEvent
/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */
abstract class MVVMBaseViewModel : ViewModel(), MVVMLifecycle {

    var bundle: Bundle = Bundle()

    val toastLiveData = SingleLiveEvent<String?>()

    fun showToast(msg: String?) {
        toastLiveData.postValue(msg)
    }

    /**
     * Lifecycle Start
     */
    override fun onCreate() {}

    override fun onPause() {}

    override fun onResume() {}

    override fun onDestroy() {}
    /**
     * Lifecycle End
     */
}