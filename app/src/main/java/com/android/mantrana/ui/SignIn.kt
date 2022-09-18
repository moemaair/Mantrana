package com.android.mantrana.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.mantrana.R
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class SignIn : AppCompatActivity() {

    private val TAG: String? = SignIn::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

       loginBtn.setOnClickListener {
           checkCredencialCouroutine()
       }

    }

    fun checkCredencialCouroutine(){
        Log.i(TAG, "start")
        GlobalScope.launch(Dispatchers.IO) {
            co()
        }
        Log.i(TAG, "end")
    }
    suspend fun co() {
        val email = emailEt.text.toString() // getting inputed email by user
        val pass = passwardEt.text.toString() // getting inputed password by user
        Log.i(TAG, "Email: $email \n Password: $pass" )
    }


}