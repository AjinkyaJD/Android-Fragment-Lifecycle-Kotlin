package com.ajinkyad.fragmentlifecycle

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ajinkyad.fragmentlifecycle.fragments.FirstFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(FirstFragment())
    }

    fun changeFragment(currentFragment: Fragment) {
        try {
            val fm = fragmentManager
            val fragmentTransaction = fm.beginTransaction()
            fragmentTransaction.add(R.id.fragmentHolder, currentFragment, "")
            fragmentTransaction.commit()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
