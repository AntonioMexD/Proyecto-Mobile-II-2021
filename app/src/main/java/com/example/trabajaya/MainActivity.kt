package com.example.trabajaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_inicio)
<<<<<<< HEAD

        val intentxd = Intent(this,PaginaInicio::class.java)
        startActivity(intentxd)

=======
>>>>>>> 46ccd75 (Se trabajo en Login y register)
    }
}