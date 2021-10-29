package com.example.trabajaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

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
    }
}