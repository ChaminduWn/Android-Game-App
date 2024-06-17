package com.example.theflyingfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class StartUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_up)

        // Delay for 5 seconds before navigating to SplashActivity
        Handler(Looper.getMainLooper()).postDelayed({
           // startActivity(Intent(this, StartActivity::class.java))
            finish()
        }, 5000) // 5000 milliseconds = 5 seconds
    }


}