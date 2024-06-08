package com.example.bankappusingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

import android.content.Intent
import com.example.bankappusingkotlin.R.id.buttonConfirm

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var onboardingAdapter: OnboardingAdapter
    private lateinit var indicatorsLayout: LinearLayout
    private lateinit var buttonNext: Button
    private lateinit var buttonBack: Button
    private lateinit var buttonConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        indicatorsLayout = findViewById(R.id.layoutIndicators)
        buttonNext = findViewById(R.id.buttonNext)
        buttonBack = findViewById(R.id.buttonBack)

        setUpOnboardingItems()
        setUpIndicators()
        setCurrentIndicator(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
                updateButtonVisibility(position)
            }
        })

        buttonNext.setOnClickListener {
            if (viewPager.currentItem + 1 < onboardingAdapter.itemCount) {
                viewPager.currentItem += 1
            } else {
                navigateToHome()
            }
        }

        buttonBack.setOnClickListener {
            if (viewPager.currentItem - 1 >= 0) {
                viewPager.currentItem -= 1
            }
        }
    }

    private fun setUpOnboardingItems() {
        val onboardingItems = listOf(
            OnboardingItem(R.drawable.intro1, "Welcome to\n" +
                    "Fundify!", "Empower your finances and earn rewards with every smart move."),
            OnboardingItem(R.drawable.intro2, "Earn FundCoins \nEasily!", "Refer friends, make transactions, and set savings goals to earn FundCoins."),
            OnboardingItem(R.drawable.intro3, "Unlock Exciting \nRewards!", "Redeem FundCoins for travel vouchers, gift cards, and more. Let's start earning!")

        )

        onboardingAdapter = OnboardingAdapter(onboardingItems)
        viewPager.adapter = onboardingAdapter
    }

    private fun setUpIndicators() {
        val indicators = arrayOfNulls<ImageView>(onboardingAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.indicator_inactive
                )
            )
            indicators[i]?.layoutParams = layoutParams
            indicatorsLayout.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = indicatorsLayout.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorsLayout.getChildAt(i) as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

    private fun updateButtonVisibility(position: Int) {
        buttonBack.visibility = if (position == 0) View.INVISIBLE else View.VISIBLE
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun navigateToPass() {
        val intent = Intent(this, PasswordActivity::class.java)
        startActivity(intent)
        finish()
    }
}
