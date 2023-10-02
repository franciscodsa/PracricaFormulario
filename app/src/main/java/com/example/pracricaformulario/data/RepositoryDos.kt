package com.example.pracricaformulario.data

import com.example.pracricaformulario.domain.modelo.Review

object RepositoryDos {
    private val  reviews = mutableListOf<Review>()

    init {
      reviews.add(Review("Review1"))
    }

    private val mapReviews = mutableMapOf<String, Review>()

    fun addReview(review: Review)=
        reviews.add(review)


    fun getReviews():List<Review>{
        return reviews
    }
}