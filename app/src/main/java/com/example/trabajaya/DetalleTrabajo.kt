package com.example.trabajaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.trabajaya.modeldb.Anuncio
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetalleTrabajo : AppCompatActivity() {
        //var user_id = intent.extras?.getLong("user_id")
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_trabajo)

                /*val anuncioDao = AppRoomDatabase.getDatabase(applicationContext).AnuncioDao()
                val repository = AnuncioRepository(anuncioDao)
                CoroutineScope(Dispatchers.IO).launch{
                        val anuncio= user_id?.let { repository.getAnuncioById(it.toInt()) }
                        llenarDatos(anuncio)
                        }*/

                val principal_bottom_navigation_menu = findViewById(R.id.principal_bottom_navigation_view) as BottomNavigationView
                principal_bottom_navigation_menu.setSelectedItemId(R.id.boton_trabajos_menu)
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

        /*fun llenarDatos(anuncio:Anuncio?){
                val titulo_trabajo=findViewById(R.id.titulo_anuncio) as TextView
                val nombre_empresa=findViewById(R.id.nombre_empresa) as TextView
                val ubicacion_trabajo=findViewById(R.id.ubicacion_trabajo) as TextView
                val descripcion_trabajo=findViewById(R.id.descripcion_trabajo) as TextView
                val requisitos_trabajo=findViewById(R.id.requisitos_trabajo) as TextView
                titulo_trabajo.text=anuncio?.titulo.toString()
                nombre_empresa.text=anuncio?.empresa.toString()
                ubicacion_trabajo.text=anuncio?.departamento.toString()
                descripcion_trabajo.text=anuncio?.descripcion.toString()
                requisitos_trabajo.text=anuncio?.requisitos.toString()
        }*/
}