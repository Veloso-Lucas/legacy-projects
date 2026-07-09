package com.lvb.challenge.picpay.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lvb.challenge.picpay.R
import com.lvb.challenge.picpay.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)
    }
}