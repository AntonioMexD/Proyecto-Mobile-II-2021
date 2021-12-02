package com.example.trabajaya

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.trabajaya.modeldb.Anuncio

@Dao
interface IAnuncioDao {
    @Query("SELECT * FROM anuncios")
    fun getList(): List<Anuncio>

    @Query("SELECT * FROM anuncios WHERE user_email= :email")
    fun getListByEmail(email: String):List<Anuncio>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(anuncio:Anuncio)

    @Query("DELETE FROM anuncios")
    fun deleteAll()

    @Query("DELETE FROM anuncios WHERE id= :id")
    fun deleteAnuncioById(id: Int)

    @Query("SELECT id,user_email,titulo,empresa,descripcion,area,departamento,jornada,requisitos,correo,telefono FROM anuncios WHERE id= :id")
    fun getAnuncioById (id: Int):Anuncio
}