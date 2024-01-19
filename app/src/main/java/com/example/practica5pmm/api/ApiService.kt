package com.example.practica5pmm.api

import com.example.practica5pmm.RazasResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("razas/{raza}/imagenes")
    suspend fun obtenerImagenesRaza(@Path("raza") raza: String): RazasResponse
}
