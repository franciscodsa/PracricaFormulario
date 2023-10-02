package com.example.pracricaformulario.ui.pantallasMain

import androidx.lifecycle.ViewModel
import com.example.pracricaformulario.domain.usecases.review.AddReviewUseCase
import com.example.pracricaformulario.domain.usecases.review.GetReview

class MainViewModel(
    private val addReviewUseCase: AddReviewUseCase,
    private val getReview: GetReview,
):ViewModel(){

}