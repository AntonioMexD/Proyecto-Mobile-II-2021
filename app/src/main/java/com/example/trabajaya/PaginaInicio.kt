package com.example.trabajaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajaya.modeldb.Anuncio
import com.google.android.material.bottomnavigation.BottomNavigationView
//import kotlinx.android.synthetic.main.activity_pagina_inicio.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaginaInicio : AppCompatActivity(), ItemClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_inicio)

        /*val lista = arrayListOf<Trabajo>()
        lista.add(Trabajo("SENIOR DESARROLLO DE SOFTWARE", "JalaSoft", "Quillacollo, Cochabamba"))
        lista.add(Trabajo("INGENIERO INDUSTRIAL", "miCompa;ia", "Sacaba"))
        lista.add(Trabajo("TABERNERO", "Insert Coin", "America y Potosi"))
        lista.add(Trabajo("TABERNERO", "Insert Coin", "America y Potosi"))

        val userListAdapter = ListaTrabajoAdaptador(lista, this)
        recyclerView.adapter = userListAdapter*/

        val anuncioDao = AppRoomDatabase.getDatabase(applicationContext).AnuncioDao()
        val repository = AnuncioRepository(anuncioDao)
        var lista= ArrayList<Anuncio>()
        CoroutineScope(Dispatchers.IO).launch{
            val listaAnuncios=repository.getListAnuncios()
            lista = arrayListOf<Anuncio>()
            listaAnuncios.forEach{
                lista.add(it)
            }}

        val recyclerView= findViewById(R.id.recyclerView) as RecyclerView
        val anuncioListAdapter = ListaAnunciosAdaptador(lista,this,this)
        recyclerView.adapter = anuncioListAdapter

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

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

    override fun onItemClickListener(anuncio: Anuncio) {
        val intentxd = Intent(this,DetalleTrabajo::class.java)
        intentxd.putExtra("anuncio_id",anuncio.id.toString())
        startActivity(intentxd)
    }
    fun abrirDetallesTrabajo(view: View) {
        startActivity(Intent(this, DetalleTrabajo::class.java))
    }

}