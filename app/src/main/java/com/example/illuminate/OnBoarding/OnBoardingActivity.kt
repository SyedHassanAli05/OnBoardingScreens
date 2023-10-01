package com.example.illuminate.OnBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.illuminate.AdapterClasses.OnBoardingAdapter
import com.example.illuminate.FeedPage
import com.example.illuminate.Login.Login
import com.example.illuminate.ModelClasses.OnboardingItem
import com.example.illuminate.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var onboardingRecyclerView: RecyclerView
    private lateinit var skipButton: Button
    lateinit var backButton: ImageView
    lateinit var dotsIndicator:DotsIndicator
    private lateinit var getStartedButton: Button

    val onboardingItems = listOf(
        OnboardingItem(
            R.drawable.nearby_illustration,
            "Find Nearby",
            "Connect and get to know people around you \n" +
                    "with similar interests."
        ),
        OnboardingItem(
            R.drawable.chat_illustration,
            "Get started",
            "Chat with people that match your vibe with \n" +
                    "just one tap.."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        findView()
        onClickListener()
        initializeRecycleView()
        addViewPager()


    }


    private fun findView()
    {
        viewPager = findViewById(R.id.view_pager)
        onboardingRecyclerView = findViewById(R.id.onboardingRecyclerView)
        skipButton = findViewById(R.id.skipButton)
        getStartedButton = findViewById(R.id.getStartedButton)
        backButton=findViewById(R.id.backButton)
        dotsIndicator=findViewById(R.id.dots_indicator)
    }

    private fun initializeRecycleView()
    {
        onboardingRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        }
    }

    private fun addViewPager()
    {
        viewPager.adapter = OnBoardingAdapter(onboardingItems)
        dotsIndicator.attachTo(viewPager)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)


                if (position == onboardingItems.size - 1) {
                    getStartedButton.text = "Get Started"
                    skipButton.visibility = View.GONE
                } else {
                    getStartedButton.text = "Next"
                    skipButton.visibility = View.VISIBLE
                }
                if (position == 0) {
                    backButton.visibility = View.GONE
                } else {
                    backButton.visibility = View.VISIBLE
                }


            }
        })

    }



    private fun onClickListener()
    {
        getStartedButton.setOnClickListener {
            val currentPosition = viewPager.currentItem
            if (currentPosition == onboardingItems.size - 1) {
                startActivity(Intent(this, FeedPage::class.java))
                finish()
            } else {
                viewPager.currentItem = currentPosition + 1
                backButton.visibility = View.VISIBLE
                skipButton.visibility = View.GONE
            }
        }

        backButton.setOnClickListener {
            val currentPosition = viewPager.currentItem
            if (currentPosition > 0) {
                viewPager.currentItem = currentPosition - 1
                skipButton.visibility = View.VISIBLE
                if (currentPosition - 1 == 0) {
                    backButton.visibility = View.GONE
                }
            }
        }

        skipButton.setOnClickListener {
            startActivity(Intent(this, FeedPage::class.java))
            finish()
        }

    }


}
