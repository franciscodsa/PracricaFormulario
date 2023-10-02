package com.example.pracricaformulario.domain.usecases.review

import com.example.pracricaformulario.data.Repository

class GetReview {

    operator fun invoke() = Repository.getInstance().getReview()
}