package com.example.practica5pmm


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    // Inicializa la lista de razas, por ejemplo, desde un recurso de cadena
    private val razas = listOf("Golden Retriever", "Labrador Retriever", "Bulldog", "Poodle", "Chihuahua")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.recyclerView)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, razas)
        listView.adapter = adaptador

        listView.setOnItemClickListener { _, _, position, _ ->
            val razaSeleccionada = razas[position]
            val intent = Intent(this, RazasImagenesActivity::class.java) // Cambia el nombre de la actividad
            intent.putExtra("raza", razaSeleccionada)
            startActivity(intent)
        }
    }
}
