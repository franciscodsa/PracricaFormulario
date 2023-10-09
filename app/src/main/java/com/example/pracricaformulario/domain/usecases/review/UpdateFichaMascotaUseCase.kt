package com.example.pracricaformulario.domain.usecases.review

import com.example.pracricaformulario.data.Repository
import com.example.pracricaformulario.domain.modelo.FichaMascota

class UpdateFichaMascotaUseCase {
    operator fun invoke(fichaMascota: FichaMascota, fichaMascotaUpdated: FichaMascota) =
        Repository.updateFichaMascota(fichaMascota, fichaMascotaUpdated)
}