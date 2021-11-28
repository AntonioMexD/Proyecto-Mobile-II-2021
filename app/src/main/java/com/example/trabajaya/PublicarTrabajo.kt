package com.example.trabajaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.trabajaya.modeldb.Anuncio
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PublicarTrabajo : AppCompatActivity() {

    lateinit var create_button : Button

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

        create_button=findViewById(R.id.boton_publicar)
        create_button.setOnClickListener{insertAnuncio()}

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
    private fun insertAnuncio() {
        val titulo = findViewById(R.id.titulo_texto) as TextInputEditText
        val empresa = findViewById(R.id.empresa_texto) as TextInputEditText
        val descripcion = findViewById(R.id.descripcion_texto) as TextInputEditText
        val area:Spinner = findViewById(R.id.spinner_area)
        val departamento:Spinner = findViewById(R.id.spinner_departamento)
        val jornada:Spinner = findViewById(R.id.spinner_jornada)
        val requisitos = findViewById(R.id.requisitos_texto)as TextInputEditText
        val correo = findViewById(R.id.correo_texto)as TextInputEditText
        val telefono = findViewById(R.id.telefono_texto)as TextInputEditText
        val user_email = FirebaseAuth.getInstance().currentUser?.email

        val anuncio = Anuncio   (titulo = titulo.text.toString(), empresa = empresa.text.toString(),
            descripcion = descripcion.text.toString(), area = area.getSelectedItem().toString(),
            departamento = departamento.getSelectedItem().toString(), jornada = jornada.getSelectedItem().toString(),
            requisitos = requisitos.text.toString(), correo = correo.text.toString(),
            telefono = telefono.text.toString(), user_email = user_email.toString()) //why id null? because id is auto generate
        val anuncioDao = AppRoomDatabase.getDatabase(applicationContext).AnuncioDao()
        val repository = AnuncioRepository(anuncioDao)
        CoroutineScope(Dispatchers.IO).launch { repository.insert(anuncio) }

    }
}