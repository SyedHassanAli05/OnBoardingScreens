
package com.example.illuminate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.illuminate.AdapterClasses.OnBoardingAdapter
import com.example.illuminate.Login.Login
import com.example.illuminate.ModelClasses.OnboardingItem

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            Handler(Looper.getMainLooper()).postDelayed({

                val intent = Intent(this, Login::class.java)
                startActivity(intent)

            }, 2000)
        }
    }
