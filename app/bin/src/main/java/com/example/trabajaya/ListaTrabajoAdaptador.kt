package com.example.trabajaya

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fila_trabajos.view.*

class ListaTrabajoAdaptador(val items: ArrayList<Trabajo>, val context: Context): RecyclerView.Adapter<ListaTrabajoAdaptador.UserListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fila_trabajos, parent, false)
        return UserListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val trabajo = items.get(position)
        holder.itemView.txtName.text = trabajo.nombre
        holder.itemView.txtCompañia.text = trabajo.compañia
        holder.itemView.txtUbicacion.text = trabajo.ubicacion
    }

    class UserListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}