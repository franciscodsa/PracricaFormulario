package com.example.pracricaformulario.domain.usecases.review

import com.example.pracricaformulario.data.Repository

class GetFichaMascotas {
    operator fun invoke() = Repository.getFichaMascotas()
}