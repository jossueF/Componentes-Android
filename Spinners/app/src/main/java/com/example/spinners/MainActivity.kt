package com.example.spinners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Un spinner reemplaza a un radiogroup cuando el tamaño de items es bastante grande como una lista de paises.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        spinnerEvents()
    }

    private fun spinnerEvents() {
        val months = resources.getStringArray(R.array.months)
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, months)
        binding.spMonths.adapter = adapter
        binding.spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You selected ${parent?.getItemAtPosition(position)}",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}