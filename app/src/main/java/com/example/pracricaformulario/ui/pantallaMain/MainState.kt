package com.example.pracricaformulario.ui.pantallaMain

import com.example.pracricaformulario.domain.modelo.Review

/*
esto da error hay que ver que me falta*/
data class MainState(
    val review: Review = Review(nombre = "asda", establecimiento= "afghfg"),
    val mensaje: String? = null
)



