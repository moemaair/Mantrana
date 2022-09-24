package com.android.mantrana.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.mantrana.R
import com.android.mantrana.snack
import kotlinx.android.synthetic.main.activity_onboarding.*
import org.w3c.dom.Text

class Onboarding : AppCompatActivity() {
    lateinit var  animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)




        SignUpNow.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)

        }
        loginWithEmail.setOnClickListener{
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }



    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if(hasFocus){
            animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
            logo_onboarding.startAnimation(animation)
        }

    }


}