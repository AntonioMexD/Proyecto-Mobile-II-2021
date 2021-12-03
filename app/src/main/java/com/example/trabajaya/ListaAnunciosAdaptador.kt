package com.example.trabajaya

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajaya.modeldb.Anuncio
import kotlinx.android.synthetic.main.activity_iniciar_sesion.view.*
import kotlinx.android.synthetic.main.fila_trabajos.view.*

class ListaAnunciosAdaptador (val items: ArrayList<Anuncio>, val context: Context, val itemClickListener: ItemClickListener): RecyclerView.Adapter<ListaAnunciosAdaptador.AnunciosListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnunciosListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fila_trabajos, parent, false)
        return AnunciosListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: AnunciosListViewHolder, position: Int) {
        val anuncio = items.get(position)
        holder.itemView.txtId.text=anuncio.id.toString()
        holder.itemView.txtName.text = anuncio.titulo
        holder.itemView.txtCompañia.text = anuncio.empresa
        holder.itemView.txtUbicacion.text = anuncio.departamento
        holder.itemView.setOnClickListener{
            itemClickListener.onItemClickListener(anuncio)
        }
    }

    class AnunciosListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}