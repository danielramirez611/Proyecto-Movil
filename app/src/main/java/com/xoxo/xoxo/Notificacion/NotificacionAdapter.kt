package com.xoxo.xoxo.Inicio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xoxo.xoxo.Notificacion.Notificacion

class NotificacionAdapter(private val listNotificacion: List<Notificacion>) : RecyclerView.Adapter<NotificacionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificacionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NotificacionViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NotificacionViewHolder, position: Int) {
        val notificacion = listNotificacion[position]
        holder.bind(notificacion)
    }

    override fun getItemCount(): Int = listNotificacion.size
}
