package com.android.mantrana.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.android.mantrana.R
import kotlinx.android.synthetic.main.activity_profile.*

class RelaxActivityLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relax_layout)
        relaxFrament()

    }



    private fun relaxFrament() {
        val f = RelaxFragment()
        val t: FragmentTransaction = supportFragmentManager.beginTransaction()
        t.replace(R.id.relax_fragment, f).commit()

    }


}