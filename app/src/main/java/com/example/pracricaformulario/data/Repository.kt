package com.example.pracricaformulario.data

import com.example.pracricaformulario.domain.modelo.FichaMascota

object Repository {
    private val  fichaMascotas = mutableListOf<FichaMascota>()

    init {
      fichaMascotas.add(FichaMascota("Juan"))
      fichaMascotas.add(FichaMascota("Pepe"))
      fichaMascotas.add(FichaMascota("Alejandro"))
    }

    fun addFichaMascota(fichaMascota: FichaMascota)=
        fichaMascotas.add(fichaMascota)


    fun getFichaMascotas():List<FichaMascota>{
        return fichaMascotas
    }
}
