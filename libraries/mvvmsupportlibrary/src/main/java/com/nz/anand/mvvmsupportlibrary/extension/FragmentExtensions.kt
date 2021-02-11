package com.nz.anand.mvvmsupportlibrary.extension

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.nz.anand.mvvmsupportlibrary.mvvm.MVVMBaseFragment
import com.nz.anand.mvvmsupportlibrary.mvvm.MVVMBaseViewModel
import com.nz.anand.mvvmsupportlibrary.mvvm.MVVMViewModelFactory

inline fun <reified VB : ViewDataBinding> Fragment.viewDataBindingOf(): VB {
    return DataBindingUtil.bind(view!!)!!
}

inline fun <reified VM : ViewModel> Fragment.viewModelOf(useActivity: Boolean = false): Lazy<VM> {
    return if (useActivity) {
        activityViewModels { MVVMViewModelFactory(requireActivity(), lifecycle) }
    } else {
        viewModels { MVVMViewModelFactory(context!!, lifecycle) }
    }
}

fun MVVMBaseFragment.bindBaseLiveData(vm: MVVMBaseViewModel) {
    vm.toastLiveData.observe(this, Observer { context?.showToast(it) })
}