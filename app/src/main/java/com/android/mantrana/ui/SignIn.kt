package com.android.mantrana.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mantrana.MainActivity
import com.android.mantrana.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignIn : AppCompatActivity() {
    private val TAG: String? = SignIn::class.simpleName

    //lateinit var email: String
    // lateinit var password: String
    private lateinit var auth: FirebaseAuth
    private lateinit var mAuthListener: AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        auth = Firebase.auth

        val emailEt = findViewById<EditText>(R.id.emailEt)
        val passEt = findViewById<EditText>(R.id.passwardEt)

        //incase not having a an account with mantrana

        SignUpNow.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        setupFirebaseAuth()

        loginBtn.setOnClickListener {
            //check for null valued EditText fields
            if (!isEmpty(emailEt.getText().toString())
                && !isEmpty(passEt.getText().toString())
            ) {
                Log.d(TAG, "Attempting to authenticate.");

                //showDialog();
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(emailEt.text.toString(), passEt.text.toString())
                    .addOnCompleteListener(this)
                    { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                            updateUI(null)
                        }
                    }
            }
            else{
                Toast.makeText(this, "You didn't fill in all the fields.", Toast.LENGTH_SHORT).show();
            }
        }


    }
    public override fun onStart() {
        super.onStart()
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }


    private fun setupFirebaseAuth() {
        Log.d(TAG, "setupFirebaseAuth: started.")
        mAuthListener = AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                Log.d(TAG, "onAuthStateChanged:signed_in:" + user.uid)
                Toast.makeText(
                    this,
                    "Authenticated with: " + user.email,
                    Toast.LENGTH_SHORT
                ).show()
               val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // User is signed out
                Log.d(TAG, "onAuthStateChanged:signed_out")
            }
        }
    }

    fun reload() {

    }

    private fun updateUI(user: FirebaseUser?) {

    }


    override fun onStop() {
        super.onStop()
        if (mAuthListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener)
        }
    }


}











