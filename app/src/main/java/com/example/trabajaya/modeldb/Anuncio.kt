package com.example.trabajaya.modeldb


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anuncios")

class Anuncio(
    @ColumnInfo(name="user_email")var user_email:String,
    @ColumnInfo(name="titulo")var titulo:String,
    @ColumnInfo(name="empresa")var empresa:String,
    @ColumnInfo(name="descripcion")var descripcion:String,
    @ColumnInfo(name="area")var area:String,
    @ColumnInfo(name="departamento")var departamento:String,
    @ColumnInfo(name="jornada")var jornada:String,
    @ColumnInfo(name="requisitos")var requisitos:String,
    @ColumnInfo(name="correo")var correo:String,
    @ColumnInfo(name="telefono")var telefono:String) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}