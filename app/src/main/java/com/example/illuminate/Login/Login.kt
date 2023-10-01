package com.example.illuminate.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.illuminate.OnBoarding.OnBoardingActivity
import com.example.illuminate.R

class Login : AppCompatActivity() {
    lateinit var btnLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findView()
        onClickListener()
    }

    private fun findView()
    {
        btnLogin=findViewById(R.id.btnLogin)
    }

    private fun onClickListener()
    {
        btnLogin.setOnClickListener {
            val intent=Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)
        }
    }
}