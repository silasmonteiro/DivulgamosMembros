package com.example.divulgamoskids

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.listOf

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val contatoAdapter = ContactAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvContacts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = contatoAdapter

        val contatos = listOf(
          Contact("Silas Miranda", "SilasMiranda", "26/06/2021", "04/07/2022"),
            Contact("lucas Miranda", "lucasMiranda", "26/08/2021", "04/09/2022"),
            Contact("Amanda Miranda", "AmandaMiranda", "26/03/2021", "04/04/2022"),
            Contact("Lara Miranda", "LaraMiranda", "26/02/2021", "04/03/2022"),
            Contact("Milena Miranda", "MilenaMiranda", "26/05/2021", "04/06/2022")

        )
        contatoAdapter.updateItems(contatos)


    }
}