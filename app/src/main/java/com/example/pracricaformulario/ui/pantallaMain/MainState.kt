package com.example.pracricaformulario.ui.pantallaMain

import com.example.pracricaformulario.domain.modelo.FichaMascota

data class MainState(
    val fichaMascota: FichaMascota = FichaMascota("", "", ""),
    val mensaje: String? = null
)



