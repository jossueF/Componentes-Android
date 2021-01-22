package com.apps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.apps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val fragmentManager: FragmentManager = supportFragmentManager
    private lateinit var fragmentTransaction: FragmentTransaction

    private lateinit var binding: ActivityMainBinding

    private val fragVerde = FragVerde()
    private val fragRojo = FragRojo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        events()
        //fragmentTransaction.add(R.id.main_frag, fragMain)
        //fragmentTransaction.commit()
    }

    fun events () {
        binding.btnVerde.setOnClickListener {
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_frag, fragVerde)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        binding.btnRojo.setOnClickListener {
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_frag, fragRojo)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}