package com.example.pracricaformulario.data

import com.example.pracricaformulario.domain.modelo.FichaMascota

object Repository {
    private val  fichaMascotas = mutableListOf<FichaMascota>()

    init {
      fichaMascotas.add(FichaMascota("Juan", "juan@mail.com", "87646413"))
      fichaMascotas.add(FichaMascota("Pepe", "pepe@mail.com", "648325432"))
      fichaMascotas.add(FichaMascota("Alejandro", "ale@mail.com", "65432101"))
    }

    fun addFichaMascota(fichaMascota: FichaMascota)=
        fichaMascotas.add(fichaMascota)


    fun getFichaMascotas():List<FichaMascota>{
        return fichaMascotas
    }

    fun deleteFichaMascota(fichaMascota: FichaMascota)=
        fichaMascotas.remove(fichaMascota)

    fun updateFichaMascota(fichaMascota: FichaMascota, fichaMascotaUpdated: FichaMascota) {
        val indice = fichaMascotas.indexOf(fichaMascota)
        fichaMascotas[indice] = fichaMascotaUpdated
    }
}
