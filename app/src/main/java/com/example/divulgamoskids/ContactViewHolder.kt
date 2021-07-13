package com.example.divulgamoskids

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class ContactViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val name = itemView.findViewById<TextView>(R.id.name)
    private val ig = itemView.findViewById<TextView>(R.id.ig)
    private val entrada = itemView.findViewById<TextView>(R.id.entrada)
    private val exit = itemView.findViewById<TextView>(R.id.exit)


        fun bind(item: Contact){
            name.text = item.nome
            ig.text = item.ig
            entrada.text = item.dataEntrada
            exit.text = item.dataSaida
        }
}