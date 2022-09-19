package com.android.mantrana.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.mantrana.MainActivity
import com.android.mantrana.R
import com.google.android.gms.common.util.CollectionUtils
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    private val TAG: String? = SignUp::class.simpleName
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var cPassword: String

    lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize Firebase Auth
        auth = Firebase.auth

        //incase user has an account with mantrana
        signInNow.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        SignUpBtn.setOnClickListener {
            //check for null valued EditText fields
            if (!isEmpty(EmailEtSignUp.getText().toString()) && !isEmpty(
                    PasswordEtSignUp.getText().toString()
                ) && !isEmpty(PasswordConfirmEtSignUp.getText().toString())
            ) {
                //check if passwords match
                if (doStringMatch(
                        PasswordEtSignUp.text.toString(),
                        PasswordConfirmEtSignUp.text.toString()
                    )
                ) {
                    registerNewEmail(
                        EmailEtSignUp.getText().toString().trim(),
                        PasswordEtSignUp.getText().toString()
                    )
                } else {
                    Toast.makeText(this, "Passwords do not Match", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "You must fill out all the fields", Toast.LENGTH_SHORT).show();
            }


        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload();
        }
    }

    private fun reload() {

    }

    private fun registerNewEmail(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun doStringMatch(pass: String, confirmPass: String): Boolean {

        return pass.equals(confirmPass)

    }

    private fun updateUI(user: FirebaseUser?) {

    }
}



