package com.example.pracricaformulario.data

import com.example.pracricaformulario.domain.modelo.Review

class Repository {
    init {
        reviews.add(Review("Review1"))
    }
    fun addReview(review: Review) = reviews.add(review)

    fun getReview(): List<Review>{
        return reviews
    }

    companion object{
        private val  reviews = mutableListOf<Review>()

        fun getInstance(): Repository = Repository()
    }
}


