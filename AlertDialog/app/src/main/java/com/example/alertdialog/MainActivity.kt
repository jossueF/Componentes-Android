package com.example.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        events()
    }

    private fun createDialog1() : AlertDialog {
        val addContactDialog = AlertDialog
                .Builder(this)
                .setTitle(getString(R.string.add_contact_name))
                .setMessage("Do you want to add this contact to your contact list?")
                .setIcon(R.drawable.ic_add_contact)
                .setPositiveButton("Yes", DialogInterface.OnClickListener
                { _, _ ->
                    Toast.makeText(this, "You added this contact to your contact list.",
                            Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("No", DialogInterface.OnClickListener
                { _, _ ->
                    Toast.makeText(this, "You didn't add this contact to your contact list.",
                            Toast.LENGTH_SHORT).show()
                })
                .create()
        return  addContactDialog
    }

    private fun createDialog2() : AlertDialog{
        val options = resources.getStringArray(R.array.options)//arrayOf("First item", "Second item", "Third item")
        val singleChoiceDialog = AlertDialog
                .Builder(this)
                .setTitle("Choose one of these options")
                .setSingleChoiceItems(options, 0, DialogInterface.OnClickListener {
                    dialog: DialogInterface?, which: Int ->
                    Toast.makeText(this, "You clicked on ${options[which]}",
                            Toast.LENGTH_SHORT).show()
                })
                .setPositiveButton("Accept", DialogInterface.OnClickListener
                { _, _ ->
                    Toast.makeText(this, "You accepted the SingleChoiceDialog",
                            Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("Decline", DialogInterface.OnClickListener
                { _, _ ->
                    Toast.makeText(this, "You declined the SingleChoiceDialog",
                            Toast.LENGTH_SHORT).show()
                })
                .create()
        return singleChoiceDialog
    }

    private fun createDialog3() : AlertDialog{
        val options = resources.getStringArray(R.array.options)//arrayOf("First item", "Second item", "Third item")
        val multiChoiceDialog = AlertDialog
                .Builder(this)
                .setTitle("Choose one of these options")
                .setMultiChoiceItems(options, booleanArrayOf(false, false, false), DialogInterface.OnMultiChoiceClickListener
                {_, which: Int, isChecked: Boolean ->
                    if (isChecked)
                        Toast.makeText(this, "You checked ${options[which]}",
                                Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this, "You unchecked ${options[which]}",
                                Toast.LENGTH_SHORT).show()
                })
                .setPositiveButton("Accept", DialogInterface.OnClickListener
                { _, _ ->
                    Toast.makeText(this, "You accepted the MultiChoiceDialog",
                            Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("Decline", DialogInterface.OnClickListener
                { _, _ ->
                    Toast.makeText(this, "You declined the MultiChoiceDialog",
                            Toast.LENGTH_SHORT).show()
                })
                .create()
        return multiChoiceDialog
    }

    private fun events() {
        binding.btnDialog1.setOnClickListener {
            createDialog1().show()
        }
        binding.btnDialog2.setOnClickListener {
            createDialog2().show()
        }
        binding.btnDialog3.setOnClickListener {
            createDialog3().show()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityMain", "Dentro de onPause()")
    }
}