package com.android.mantrana.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.mantrana.MainActivity
import com.android.mantrana.R
import com.android.mantrana.snack
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        edit_profile_topBar.setOnClickListener{
            edit_profile_topBar.snack("Do you wish to Edit your profile? Click here")
        }
        takeMeHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        signOutTv.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, Onboarding::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
        edit_profile.setOnClickListener{
            val intent = Intent(this, RelaxActivityLayout::class.java)
            startActivity(intent)
        }
    }
}