package com.example.capitales.auth

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.capitales.R
import com.example.capitales.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginFragment.LoginFragmentActions, SignUpFragment.SignUpFragmentActions {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onRegisterButtonClick() { //CON EL CLIC TE LLEVA AL SIGNUP
        findNavController(R.id.nav_host_fragment)
            .navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
    }

    override fun onReturnToLoginClick() { //AL HACER CLIC DESDE SIGNUP VUELVE AL LOGIN
        findNavController(R.id.nav_host_fragment)
            .navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
    }
}