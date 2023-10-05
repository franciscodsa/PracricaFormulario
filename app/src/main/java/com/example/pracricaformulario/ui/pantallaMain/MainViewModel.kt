package com.example.pracricaformulario.ui.pantallaMain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pracricaformulario.R
import com.example.pracricaformulario.domain.modelo.FichaMascota
import com.example.pracricaformulario.domain.usecases.review.AddFichaMascotaUseCase
import com.example.pracricaformulario.domain.usecases.review.GetFichaMascotas
import com.example.pracricaformulario.utils.StringProvider




class MainViewModel(
    private val stringProvider: StringProvider,
    private val addFichaMascotaUseCase: AddFichaMascotaUseCase,
    private val getFichaMascotas: GetFichaMascotas,
):ViewModel() {

    private val _uiState = MutableLiveData<MainState>()

    val uiState: LiveData<MainState> get() = _uiState

    fun addFichaMascota(fichaMascota: FichaMascota) {

        if (!addFichaMascotaUseCase(fichaMascota)) {
            _uiState.value = MainState(mensaje = stringProvider.getString(R.string.name))
            _uiState.value = _uiState.value?.copy(mensaje = Constantes.MENSAJE)
        }else{
            _uiState.value = MainState(mensaje = "Ficha añadida")
        }
    }


    // Índice actual
    private var indiceActual = 0
    fun mostrarSiguienteFicha() {
        // Obtén la lista de fichas de mascota
        val fichaMascotas = getFichaMascotas()

        // Verifica si el índice está dentro de los límites de la lista
        if (indiceActual < fichaMascotas.size) {

            // Actualiza el mensaje con el nombre del propietario actual
            val fichaActual = fichaMascotas[indiceActual]
            _uiState.value = MainState(fichaMascota = fichaActual, mensaje = null)
            indiceActual++
        } else  {
            // Si no hay más propietarios, muestra un mensaje de finalización
            _uiState.value = MainState(mensaje = Constantes.NO_HAY_SIGUIENTE)
        }
    }

    fun mostrarFichaAnterior() {
        if (indiceActual > 0) {
            indiceActual--
            val fichaMascotas = getFichaMascotas()
            val fichaActual = fichaMascotas[indiceActual]
            _uiState.value = MainState(fichaMascota = fichaActual, mensaje = null)
        } else {
            _uiState.value = MainState(mensaje = Constantes.NO_HAY_ANTERIOR)
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
    private val addFichaMascota: AddFichaMascotaUseCase,
    private val getFichaMascotas: GetFichaMascotas,
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(
                stringProvider,
                addFichaMascota,
                getFichaMascotas,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}