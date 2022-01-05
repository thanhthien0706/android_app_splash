package com.example.learn_android_splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val SPLASH_SCREEN: Long = 4000

    private lateinit var topAnimaiton: Animation
    private lateinit var bottomAnimation: Animation
    private lateinit var img_main: ImageView
    private lateinit var logo: TextView
    private lateinit var slogan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        addCotrollers()
        addEvents()
    }

    private fun addCotrollers() {
        topAnimaiton = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

//        Hooks
        img_main = findViewById(R.id.img_main)
        logo = findViewById(R.id.logo)
        slogan = findViewById(R.id.slogan)

        img_main.startAnimation(topAnimaiton)
        logo.startAnimation(bottomAnimation)
        slogan.startAnimation(bottomAnimation)

    }

    private fun addEvents() {
        Handler(Looper.getMainLooper()).postDelayed({
            val mainIntent = Intent(this, DashboardActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_SCREEN)
    }
}