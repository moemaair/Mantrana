package com.android.mantrana.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.mantrana.R
import com.android.mantrana.snack
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        edit.setOnClickListener{
            edit.snack("Do you wish to Edit your profile? Click here")
        }
    }
}