package com.ajinkyad.fragmentlifecycle.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ajinkyad.fragmentlifecycle.MainActivity
import com.ajinkyad.fragmentlifecycle.R

class FirstFragment : ParentFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_first, container, false)

        view!!.findViewById<Button>(R.id.btnSecondFragment).setOnClickListener {
            (activity as MainActivity).changeFragment(SecondFragment())
        }

        return view
    }
}