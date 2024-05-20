package com.xoxo.xoxo.Inicio

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xoxo.xoxo.Notificacion.Notificacion
import com.xoxo.xoxo.R

class NotificacionViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_notificacion, parent, false)) {

    private var textNotificacion: TextView? = null


    init {
        textNotificacion = itemView.findViewById(R.id.textNotificacion)



    }

    fun bind(notificacion: Notificacion) {
        textNotificacion?.text = notificacion.info

    }

}
