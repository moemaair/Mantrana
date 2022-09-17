package com.android.mantrana.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.android.mantrana.R

class RelaxActivityLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relax_layout)
        val f = RelaxFragment()
        val t: FragmentTransaction = supportFragmentManager.beginTransaction()
        t.replace(R.id.relax_fragment, f).commit()
    }
}