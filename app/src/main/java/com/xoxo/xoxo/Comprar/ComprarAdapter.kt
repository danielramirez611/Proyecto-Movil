package com.xoxo.xoxo.Comprar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ComprarAdapter(private val listComprar: List<Comprar>) : RecyclerView.Adapter<ComprarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComprarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ComprarViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ComprarViewHolder, position: Int) {
        val comprar = listComprar[position]
        holder.bind(comprar)
    }

    override fun getItemCount(): Int = listComprar.size
}
