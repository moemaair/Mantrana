package com.android.mantrana.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mantrana.MainActivity
import com.android.mantrana.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class SignIn : AppCompatActivity() {
    private val TAG: String? = SignIn::class.simpleName

     //lateinit var email: String
    // lateinit var password: String
     //private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        //auth = Firebase.auth

        val emailEt = findViewById<EditText>(R.id.emailEt)

        val passEt = findViewById<EditText>(R.id.passwardEt)

        //incase not having a an account with mantrana

        SignUpNow.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

//        email = emailEt.text.toString()
//        password = passEt.text.toString()


       loginBtn.setOnClickListener {
//           checkCredencialCouroutine()

           if(emailEt.text.toString().equals("") && passEt.text.toString().equals("")){
               Toast.makeText(this, "required Email and password", Toast.LENGTH_SHORT)
                   .show()
           }
           else{
               // [START sign_in_with_email]
//               FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEt.text.toString().trim(), passwardEt.text.toString().trim())
//                   .addOnCompleteListener(this) { task ->
//                       if (task.isSuccessful) {
//                           // Sign in success, update UI with the signed-in user's information
//                           Log.d(TAG, "signInWithEmail:success" + FirebaseAuth.getInstance().currentUser?.uid)
//                           //FirebaseAuth.getInstance().signOut()
//                           //val user = auth.currentUser
//                           updateUI(user)
//
////                           val intent = Intent(this, MainActivity::class.java)
////                           startActivity(intent)
////                           finish()
//                       } else {
//                           // If sign in fails, display a message to the user.
//                           Log.w(TAG, "signInWithEmail:failure", task.exception)
//                           Toast.makeText(baseContext, "Authentication failed.",
//                               Toast.LENGTH_SHORT).show()
//                           updateUI(null)
//                       }
//                   }
               // [END sign_in_with_email]



           }
       }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
////        val currentUser = auth.currentUser
//        if(currentUser != null){
//            reload();
//        }
    }

    private fun updateUI(user: FirebaseUser?) {

    }
}
fun reload() {
    }

//    fun checkCredencialCouroutine(){
//        Log.i(TAG, "start")
//        GlobalScope.launch(Dispatchers.IO) {
//            co()
//        }
//        Log.i(TAG, "end")
//    }
//    suspend fun co() {
//        Log.i(TAG, "Email: $emailValue \n Password: $passwordValue" )
//    }



