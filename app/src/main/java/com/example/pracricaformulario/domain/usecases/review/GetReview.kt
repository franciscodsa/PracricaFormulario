package com.example.pracricaformulario.domain.usecases.review

import com.example.pracricaformulario.data.RepositoryDos

class GetReview {
    operator fun invoke() =
        RepositoryDos.getReviews()
}