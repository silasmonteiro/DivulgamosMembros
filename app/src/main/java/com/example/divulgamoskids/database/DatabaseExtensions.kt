package com.example.divulgamoskids.database

import android.content.ContentValues
import com.example.divulgamoskids.Contact

fun ContatosDatabase.salvarContato(item: Contact): Long {

    val idContato = writableDatabase.insert("TB_CONTATOS", null, ContentValues().apply {
        put("NOME", item.nome)
        put("IG", item.ig)
        put("DATA_ENTRADA", item.dataEntrada)
        put("DATA_SAIDA", item.dataSaida)
    })
    return idContato
}
fun ContatosDatabase.selecionarContatos(): List<Contact>{

    val sql = "SELECT * FROM TB_CONTATOS"

    val cursor = readableDatabase.rawQuery(sql, null)

    val returnBanco = mutableListOf<Contact>()
    if(cursor.count > 0){

        while(cursor.moveToNext()) { // percorre a lista

            val contato = Contact(

                id = cursor.getInt(cursor.getColumnIndex("ID")),
                nome = cursor.getString(cursor.getColumnIndex("NOME")),
                ig = cursor.getString(cursor.getColumnIndex("IG")),
                dataEntrada = cursor.getString(cursor.getColumnIndex("DATA_ENTRADA")),
                dataSaida = cursor.getString(cursor.getColumnIndex("DATA_SAIDA"))
            )

            returnBanco.add(contato)
        }
        cursor.close()
    }

    return returnBanco

}

fun ContatosDatabase.alteracaoContato(item: Contact): Int{

    val valores = ContentValues().apply {
        put("NOME", item.nome)
        put("IG", item.ig)
        put("DATA_ENTRADA", item.dataEntrada)
        put("DATA_SAIDA", item.dataSaida)
    }

    return writableDatabase.update("TB_CONTATOS", valores,"ID=${item.id}",null)
}