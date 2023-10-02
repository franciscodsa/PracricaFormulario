package com.example.pracricaformulario.domain.usecases.review

import com.example.pracricaformulario.data.RepositoryDos
import com.example.pracricaformulario.domain.modelo.Review

class AddReviewUseCase {
    operator fun invoke(review: Review) =
        RepositoryDos.addReview(review)
}