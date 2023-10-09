package com.example.pracricaformulario.ui.pantallaMain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pracricaformulario.R
import com.example.pracricaformulario.domain.modelo.FichaMascota
import com.example.pracricaformulario.domain.usecases.review.AddFichaMascotaUseCase
import com.example.pracricaformulario.domain.usecases.review.DeleteFichaMascota
import com.example.pracricaformulario.domain.usecases.review.GetFichaMascotas
import com.example.pracricaformulario.domain.usecases.review.UpdateFichaMascotaUseCase
import com.example.pracricaformulario.utils.StringProvider




class MainViewModel(
    private val stringProvider: StringProvider,
    private val addFichaMascotaUseCase: AddFichaMascotaUseCase,
    private val getFichaMascotas: GetFichaMascotas,
    private val deleteFichaMascota: DeleteFichaMascota,
    private val updateFichaMascotaUseCase: UpdateFichaMascotaUseCase,
) : ViewModel() {

    private val _uiState = MutableLiveData<MainState>()

    val uiState: LiveData<MainState> get() = _uiState

    private var fichaMascotas: List<FichaMascota> = emptyList()
    private var indiceActual = -1 // Inicialmente no hay ficha actual

    init {
        cargarFichaMascotas()
    }

    private fun cargarFichaMascotas() {
        fichaMascotas = getFichaMascotas()
    }

    fun addFichaMascota(fichaMascota: FichaMascota) {
        if (!addFichaMascotaUseCase(fichaMascota)) {
            _uiState.value = MainState(mensaje = stringProvider.getString(R.string.name))
            _uiState.value = _uiState.value?.copy(mensaje = Constantes.MENSAJE)
        } else {
            cargarFichaMascotas() // Recargar la lista de fichas
            mostrarSiguienteFicha()
            _uiState.value = MainState(mensaje = Constantes.FICHA_AÑADIDA)
        }
    }

    fun mostrarSiguienteFicha() {
        if (fichaMascotas.isNotEmpty()) {
            indiceActual = (indiceActual + 1) % fichaMascotas.size
            val fichaActual = fichaMascotas[indiceActual]
            _uiState.value = MainState(fichaMascota = fichaActual, mensaje = null)
        }
    }

    fun mostrarFichaAnterior() {
        if (fichaMascotas.isNotEmpty()) {
            indiceActual = (indiceActual - 1 + fichaMascotas.size) % fichaMascotas.size
            val fichaActual = fichaMascotas[indiceActual]
            _uiState.value = MainState(fichaMascota = fichaActual, mensaje = null)
        }
    }

    fun eliminarFichaActual() {
        if (fichaMascotas.isNotEmpty() && indiceActual >= 0 && indiceActual < fichaMascotas.size) {
            val fichaActual = fichaMascotas[indiceActual]
            deleteFichaMascota(fichaActual)
            cargarFichaMascotas() // Recargar la lista de fichas después de eliminar
            indiceActual = -1 // No hay ficha actual después de eliminar
            _uiState.value = MainState(mensaje = Constantes.FICHA_ELIMINADA)
        } else {
            _uiState.value = MainState(mensaje = "No hay fichas para eliminar")
        }
    }

    fun modificarFichaActual(fichaMascotaModificada: FichaMascota){
        if (fichaMascotas.isNotEmpty() && indiceActual >= 0 && indiceActual < fichaMascotas.size) {
            updateFichaMascotaUseCase(fichaMascotas[indiceActual], fichaMascotaModificada)
            _uiState.value = _uiState.value?.copy(mensaje = "ficha modificada")
        }else{
            _uiState.value = MainState(mensaje = "No hay fichas para modificar")
        }
    }
    fun mensajeMostrado() {
        _uiState.value = _uiState.value?.copy(mensaje = null)
    }
}

/**
 * Factory class to instantiate the [ViewModel] instance.
 */
class MainViewModelFactory(
    private val stringProvider: StringProvider,
    private val addFichaMascotaUseCase: AddFichaMascotaUseCase,
    private val getFichaMascotas: GetFichaMascotas,
    private val deleteFichaMascota: DeleteFichaMascota,
    private val updateFichaMascotaUseCase: UpdateFichaMascotaUseCase,
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(
                stringProvider,
                addFichaMascotaUseCase,
                getFichaMascotas,
                deleteFichaMascota,
                updateFichaMascotaUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}