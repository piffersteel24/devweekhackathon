package com.example.whatever

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        id_logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in))

        Handler().postDelayed({
            id_logo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_out))
            Handler().postDelayed({
                id_logo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_in))
                Handler().postDelayed({
                    id_logo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_out))
                    Handler().postDelayed({
                        id_logo.visibility = View.GONE
                        startActivity(Intent(this, SplashActivity::class.java))
                        finish()

                    }, 1000)
                }, 700)

            }, 500)
        },700)
    }
}

