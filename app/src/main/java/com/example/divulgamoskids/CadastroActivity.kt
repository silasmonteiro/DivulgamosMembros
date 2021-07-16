package com.example.divulgamoskids

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.divulgamoskids.database.ContatosDatabase
import com.example.divulgamoskids.database.salvarContato

class CadastroActivity : AppCompatActivity() {

    private lateinit var nome: EditText
    private lateinit var ig: EditText
    private lateinit var dataEntrada: EditText
    private lateinit var dataSaida: EditText
    private lateinit var buttonSalvar: Button

    private lateinit var database: ContatosDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        nome = findViewById(R.id.nome)
        ig = findViewById(R.id.ig)
        dataEntrada = findViewById(R.id.dataEntrada)
        dataSaida = findViewById(R.id.dataSaida)
        buttonSalvar = findViewById(R.id.buttonSalvar)
        database = ContatosDatabase(this)



        buttonSalvar.setOnClickListener {
            salvarContato()
        }

    }

    private fun salvarContato(){

        val contact = Contact(
            nome = nome.text.toString(),
            ig = ig.text.toString(),
            dataEntrada = dataEntrada.text.toString(),
            dataSaida = dataSaida.text.toString()
        )

       val idcontato =  database.salvarContato(contact)

        if(idcontato == -1L) {

            Toast.makeText(this, "ERRO AO SALVAR", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "SALVO COM SUCESSO ID: $idcontato", Toast.LENGTH_SHORT).show()
        }



    }
}