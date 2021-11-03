package com.example.trabajaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.bottomnavigation.BottomNavigationView

class PublicarTrabajo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicar_trabajo)

        val spinnerArea = findViewById<Spinner>(R.id.spinner_area)
        val areas = listOf("Finanzas","Comida","Tecnologia")
        val adaptadorAreas = ArrayAdapter(this,android.R.layout.simple_spinner_item,areas)
        spinnerArea.adapter = adaptadorAreas

        val spinner_departamento = findViewById<Spinner>(R.id.spinner_departamento)
        val departamentos = listOf("Cochabamba","Santa Cruz","La Paz")
        val adaptador_departamento = ArrayAdapter(this,android.R.layout.simple_spinner_item,departamentos)
        spinner_departamento.adapter = adaptador_departamento

        val spinner_jornada = findViewById<Spinner>(R.id.spinner_jornada)
        val jornadas = listOf("Medio tiempo","Tiempo completo")
        val adaptador_jornada = ArrayAdapter(this,android.R.layout.simple_spinner_item,jornadas)
        spinner_jornada.adapter = adaptador_jornada

        val principal_bottom_navigation_menu = findViewById(R.id.principal_bottom_navigation_view) as BottomNavigationView
        principal_bottom_navigation_menu.setSelectedItemId(R.id.boton_publicar_trabajo_menu)
        principal_bottom_navigation_menu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.boton_trabajos_menu->{
                    val intentxd = Intent(this,PaginaInicio::class.java)
                    startActivity(intentxd)
                    true
                }
                R.id.boton_cuenta_menu -> {
                    val intentxd = Intent(this,PerfilUsuario::class.java)
                    startActivity(intentxd)
                    true
                }
                R.id.boton_publicar_trabajo_menu -> {
                    val intentxd = Intent(this,PublicarTrabajo::class.java)
                    startActivity(intentxd)
                    true
                }
                else -> true
            }
        }
    }
}