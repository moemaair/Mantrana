package com.android.mantrana

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.mantrana.ui.Onboarding
import com.android.mantrana.ui.Profile
import com.android.mantrana.ui.RelaxFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


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
//        relax.setOnClickListener{
//         val intent = Intent(this, RelaxActivityLayout::class.java)
//            startActivity(intent)
//        }
        hamburger.setOnClickListener{
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Do you want to log out?")
            alert.setIcon(R.mipmap.logo_big)

            alert.setPositiveButton("Ok") { dialog, whichButton ->
                //Your action here
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, Onboarding::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()

            }

            alert.setNegativeButton("Cancel") { dialog, whichButton ->
                dialog.cancel()

            }

            alert.show()
        }

    }






}