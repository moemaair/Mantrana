package com.android.mantrana

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.GREEN
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.fragment.app.FragmentTransaction
import com.android.mantrana.ui.Profile
import com.android.mantrana.ui.RelaxActivityLayout
import com.android.mantrana.ui.RelaxFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers.Main
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fragments
        val bundle = Bundle()
        val fragmentRelax = RelaxFragment()
        fragmentRelax.arguments = bundle


        hamburger.setOnClickListener{
            hamburger.snack("Your message"  )
        }
        val profile = findViewById<ImageButton>(R.id.profile)
        profile.setOnClickListener{
            val intent = Intent(this,Profile::class.java)
            startActivity(intent)
        }
        relax.setOnClickListener{
         val intent = Intent(this, RelaxActivityLayout::class.java)
            startActivity(intent)
        }

    }






}