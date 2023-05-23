package com.example.exam2305task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam2305task1.databinding.ActivityDetailOfMovieBinding
import com.example.exam2305task1.databinding.ActivityMainBinding
import com.example.exam2305task1.model.JackReacher
import com.example.exam2305task1.model.Parameters

class DetailOfMovie : AppCompatActivity() {
    lateinit var binding: ActivityDetailOfMovieBinding
    lateinit var jackReacher : Parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailOfMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        jackReacher = intent.getSerializableExtra("JackReacher") as Parameters
        binding.overviewId.setText(jackReacher.overview)
        binding.originalTitleId2.setText(jackReacher.original_title)
        binding.releaseDateId2.setText(jackReacher.release_date)
        binding.originalLanguage.setText(jackReacher.original_language)
        binding.popularityId2.setText(jackReacher.popularity.toString())
    }
}