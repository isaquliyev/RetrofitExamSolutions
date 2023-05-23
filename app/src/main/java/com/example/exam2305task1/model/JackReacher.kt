package com.example.exam2305task1.model

import java.io.Serializable

data class JackReacher(
    var page: Int,
    var results: List<Parameters>,
    var total_pages: Int,
    var total_results: Int,
) : Serializable
