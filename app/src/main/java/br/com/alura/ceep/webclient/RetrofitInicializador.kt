package br.com.alura.ceep.webclient

import br.com.alura.ceep.webclient.services.NotaService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInicializador {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://6323-2804-7f0-18-250-58e3-9587-c91e-ef1f.ngrok-free.app")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val notaService = retrofit.create(NotaService::class.java)
}