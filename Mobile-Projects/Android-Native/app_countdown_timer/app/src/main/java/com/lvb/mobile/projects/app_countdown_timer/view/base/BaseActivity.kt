package com.lvb.mobile.projects.app_countdown_timer.view.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding, VM: ViewModel>: AppCompatActivity()  {

    private var _binding: VB? = null
    protected val binding get() = _binding!!
    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
    }

    abstract fun getViewBinding(): VB

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}