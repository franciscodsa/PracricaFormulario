package com.example.pracricaformulario.ui.pantallaMain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pracricaformulario.R
import com.example.pracricaformulario.domain.modelo.Review
import com.example.pracricaformulario.domain.usecases.review.AddReviewUseCase
import com.example.pracricaformulario.domain.usecases.review.GetReview
import com.example.pracricaformulario.utils.StringProvider

class MainViewModel(
    private val stringProvider: StringProvider,
    private val addReviewUseCase: AddReviewUseCase,
    private val getReview: GetReview,
):ViewModel(){

    private val _uiState = MutableLiveData<MainState>()

    val uiState: LiveData<MainState> get() = _uiState

    fun addReview(review: Review){
        if (!addReviewUseCase(review)){
            _uiState.value= MainState(
                mensaje= stringProvider.getString(R.string.name)
            )
            _uiState.value = _uiState.value?.copy(mensaje = Constantes.MENSAJE)
        }
    }

    fun getReview(id: Int){
        val reviews = getReview()

        if (reviews.size < id || id <0){
            _uiState.value = _uiState.value?.copy(mensaje = Constantes.MENSAJE)
        }else
            _uiState.value = _uiState.value?.copy(review = reviews[id])
    }

    fun mensajeMostrado(){
        _uiState.value = _uiState.value?.copy(mensaje = null)
    }

}

/**
 * Factory class to instantiate the [ViewModel] instance.
 */
class MainViewModelFactory(
    private val stringProvider: StringProvider,
    private val addReview: AddReviewUseCase,
    private val getReview: GetReview,

    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(
                stringProvider,
                addReview,
                getReview,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}