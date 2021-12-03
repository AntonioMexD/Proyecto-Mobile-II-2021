package com.example.trabajaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajaya.modeldb.Anuncio
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_pagina_inicio.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PerfilUsuario : AppCompatActivity(), ItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_usuario)

        val nombre_usuario = findViewById(R.id.tv_name) as TextView
        val email_usuario = findViewById(R.id.user_email) as TextView

        val user = FirebaseAuth.getInstance().currentUser
        val mDb = FirebaseDatabase.getInstance().getReference()
        val user_id= user!!.uid
        mDb.child("User").child(user_id).addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user_name:String = dataSnapshot.child("Name").value.toString()
                val user_lastName:String = dataSnapshot.child("LastName").value.toString()
                nombre_usuario.text= user_name +" "+ user_lastName
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        email_usuario.text=user?.email.toString()

        val anuncioDao = AppRoomDatabase.getDatabase(applicationContext).AnuncioDao()
        val repository = AnuncioRepository(anuncioDao)
        var lista= ArrayList<Anuncio>()
        CoroutineScope(Dispatchers.IO).launch{
            val listaAnuncios=repository.getListAnunciosByEmail(user?.email.toString())
            lista = arrayListOf<Anuncio>()
            listaAnuncios.forEach{
                lista.add(it)
            }}

        val anuncioListAdapter = ListaAnunciosAdaptador(lista,this,this)
        recyclerView.adapter = anuncioListAdapter

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        val principal_bottom_navigation_menu = findViewById(R.id.principal_bottom_navigation_view) as BottomNavigationView
        principal_bottom_navigation_menu.setSelectedItemId(R.id.boton_cuenta_menu)
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
        //Toast.makeText(this,anuncio.titulo, Toast.LENGTH_LONG).show()
    }
}