package com.example.divulgamoskids

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter: RecyclerView.Adapter<ContactViewHolder>() {

    private var items = listOf<Contact>()

    fun updateItems(newItems: List<Contact>){

        items = newItems
        notifyDataSetChanged() // avisa a lista que tem items novos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.ambassador, parent,false)

        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

            val item = items[position]

        holder.bind(item) // era pra entrar (items(position))
    }


}