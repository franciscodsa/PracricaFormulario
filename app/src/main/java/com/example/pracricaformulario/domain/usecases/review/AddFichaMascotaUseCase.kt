package com.example.pracricaformulario.domain.usecases.review

import com.example.pracricaformulario.data.Repository
import com.example.pracricaformulario.domain.modelo.FichaMascota

class AddFichaMascotaUseCase {
    operator fun invoke(fichaMascota: FichaMascota) =
        Repository.addFichaMascota(fichaMascota)
}