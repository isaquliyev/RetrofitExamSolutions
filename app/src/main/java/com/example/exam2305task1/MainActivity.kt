package com.example.exam2305task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam2305task1.adapter.Adapter
import com.example.exam2305task1.adapter.Adapter2
import com.example.exam2305task1.adapter.OnItemClickListener
import com.example.exam2305task1.databinding.ActivityMainBinding
import com.example.exam2305task1.model.JackReacher
import com.example.exam2305task1.model.Parameters
import com.example.exam2305task1.model.UpcomingFilms
import com.example.exam2305task1.network.RetrofitClient
import com.example.exam2305task1.network.RetrofitClientUpcoming
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        setContentView(binding.root)
        getFilms()
        // getUpcomingFilms()
    }

    fun getFilms() {
        val call: Call<JackReacher> = RetrofitClient.getInstances()!!
            .getMyApi().getFilms()
        call!!.enqueue(object : Callback<JackReacher> {

            override fun onResponse(call: Call<JackReacher>, response: Response<JackReacher>) {
                val newsList: JackReacher = response.body() as JackReacher
                binding.recyclerView.adapter = Adapter(newsList, object : OnItemClickListener {
                    override fun OnItemClick(item: Parameters) {
                        val intent = Intent(this@MainActivity,DetailOfMovie::class.java)
                        intent.putExtra("JackReacher",item)
                        startActivity(intent)
                    }
                })
            }

            override fun onFailure(call: Call<JackReacher>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
//    fun getUpcomingFilms() {
//        val call: Call<UpcomingFilms> = RetrofitClientUpcoming.getInstances()!!
//            .getMyApi().getUpcomingFilms()
//        call!!.enqueue(object : Callback<UpcomingFilms> {
//
//            override fun onResponse(call: Call<UpcomingFilms>, response: Response<UpcomingFilms>) {
//                val newsList2: JackReacher = response.body() as UpcomingFilms
//                binding.recyclerView2.adapter = Adapter2(newsList2)
//            }
//
//            override fun onFailure(call: Call<UpcomingFilms>, t: Throwable) {
//                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
//            }
//        })
//    }

}