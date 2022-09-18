package com.android.mantrana.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.mantrana.R
import com.android.mantrana.snack
import kotlinx.android.synthetic.main.activity_onboarding.*

class Onboarding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        SignUpNow.setOnClickListener{
            SignUpNow.snack("sign up page...")
        }
        loginWithEmail.setOnClickListener{
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

    }
}