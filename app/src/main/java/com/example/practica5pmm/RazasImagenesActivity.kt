package com.example.practica5pmm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.practica5pmm.adapters.AdaptadorImagenes
import com.example.practica5pmm.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RazasImagenesActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_razas_imagenes) // Asegúrate de que este sea el nombre correcto del layout

        val raza = intent.getStringExtra("raza") ?: ""
        apiService = Retrofit.Builder()
            .baseUrl("https://www.thedogapi.com/") // Reemplaza con la URL de la API real
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        viewPager = findViewById(R.id.viewPager)

        // Inicia la carga de imágenes y muestra la información en la UI
        cargarImagenes(raza)
    }

    private fun cargarImagenes(raza: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val respuesta = apiService.obtenerImagenesRaza(raza)
                val imagenes = respuesta.imagenes.take(5) // Obtener hasta 5 imágenes

                runOnUiThread {
                    val adaptador = AdaptadorImagenes(imagenes)
                    viewPager.adapter = adaptador
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
