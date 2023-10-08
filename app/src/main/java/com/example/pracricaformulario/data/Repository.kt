package com.example.pracricaformulario.data

import com.example.pracricaformulario.domain.modelo.FichaMascota

object Repository {
    private val  fichaMascotas = mutableListOf<FichaMascota>()

    init {
      fichaMascotas.add(FichaMascota("Juan", "juan@mail.com"))
      fichaMascotas.add(FichaMascota("Pepe", "pepe@mail.com"))
      fichaMascotas.add(FichaMascota("Alejandro", "ale@mail.com"))
    }

    fun addFichaMascota(fichaMascota: FichaMascota)=
        fichaMascotas.add(fichaMascota)


    fun getFichaMascotas():List<FichaMascota>{
        return fichaMascotas
    }

    fun deleteFichaMascota(fichaMascota: FichaMascota)=
        fichaMascotas.remove(fichaMascota)
}
