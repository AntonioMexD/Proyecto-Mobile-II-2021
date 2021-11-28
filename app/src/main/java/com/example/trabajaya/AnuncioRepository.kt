package com.example.trabajaya

import com.example.trabajaya.modeldb.Anuncio

class AnuncioRepository(private val anuncioDao: IAnuncioDao) {

    fun insert(anuncio: Anuncio) {
        anuncioDao.insert(anuncio)
    }

    fun getListAnuncios(): List<Anuncio> {
        return anuncioDao.getList()
    }

    fun getListAnunciosByEmail(email:String):List<Anuncio>{
        return  anuncioDao.getListByEmail(email)
    }
}