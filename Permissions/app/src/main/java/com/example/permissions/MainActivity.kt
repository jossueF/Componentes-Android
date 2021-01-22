package com.example.permissions

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.permissions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        events()
    }

    private fun events() {
        binding.btnRequestPermissions.setOnClickListener {
            requestPermissions()
        }
    }

    // Funciones para saber si el usuario acepto los permisos
    private fun hasWriteExternalStoragePermission() =
        ActivityCompat.checkSelfPermission(
            this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationBackgroundPermission() =
        ActivityCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

    // Función para saber cuando el usuario acepto los permisos
    private fun requestPermissions() {
        var permissionsToRequest = mutableListOf<String>()
        if(!hasWriteExternalStoragePermission()) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if(!hasLocationForegroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(!hasLocationBackgroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
            //Log.d("ActivityMain", "permissionsToRequest.isNotEmpty()")
        }
        //Log.d("ActivityMain", "Dentro del método requestPermissions()")
    }

    // En ésta función recorremos los permisos concedidos
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //Log.d("ActivityMain", "Dentro de onRequestPermissionsResult()")
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            //Log.d("ActivityMain", "Dentro de grantResults.isNotEmpty()")
            for(i in grantResults.indices) {
                //Log.d("ActivityMain", "${permissions[i]}")
                //Log.d("ActivityMain", "${grantResults[i]}")
                if(grantResults[i] == PackageManager.PERMISSION_DENIED){
                    Log.d("PermissionsRequest", "${permissions[i]} granted.")
                }
            }
        }
    }
}