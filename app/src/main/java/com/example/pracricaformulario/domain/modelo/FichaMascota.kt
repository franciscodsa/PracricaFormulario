package com.example.pracricaformulario.domain.modelo

data class FichaMascota(
    val propietario: String = "",
    val email: String = "",
    val telefono: String = "",
    val nombreMascota: String = "",
    val especie: Int,
    val esterilizado: Boolean = false,
    val vacunado: Boolean = false,
    val comportamiento: Float = 0.0f
)
