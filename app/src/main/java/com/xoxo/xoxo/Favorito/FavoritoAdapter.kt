package com.xoxo.xoxo.Favorito

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FavoritoAdapter(private val listFavorito: List<Favorito>) : RecyclerView.Adapter<FavoritoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FavoritoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FavoritoViewHolder, position: Int) {
        val favorito = listFavorito[position]
        holder.bind(favorito)
    }

    override fun getItemCount(): Int = listFavorito.size
}
