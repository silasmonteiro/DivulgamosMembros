package com.example.divulgamoskids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.divulgamoskids.database.ContatosDatabase
import com.example.divulgamoskids.database.selecionarContatos
import kotlin.collections.listOf

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val contatoAdapter = ContactAdapter()

    private lateinit var database: ContatosDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvContacts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = contatoAdapter


        database = ContatosDatabase(this)

        val contatos = database.selecionarContatos()

        contatoAdapter.updateItems(contatos)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_cadastro -> {
                val intent = Intent(this,CadastroActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {
                false
            }

        }
        return super.onOptionsItemSelected(item)
    }
}