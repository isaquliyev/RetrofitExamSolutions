package com.example.exam2305task1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam2305task1.R
import com.example.exam2305task1.model.JackReacher
import com.example.exam2305task1.model.UpcomingFilms
import com.squareup.picasso.Picasso

class Adapter2(list: UpcomingFilms) : RecyclerView.Adapter<Adapter2.ViewHolder>() {
    var list: UpcomingFilms

    init {
        this.list = list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date1 = itemView.findViewById<TextView>(R.id.date1)
        var date2 = itemView.findViewById<TextView>(R.id.date2)
        var imagePath2 = itemView.findViewById<TextView>(R.id.imagePath2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.recycler_view_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date1.setText(list.dates[0])
        holder.date2.setText(list.dates[1])
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500${list.results.get(position).poster_path}")
            .into(holder.imagePath2)
    }


}

//var date1 = itemView.findViewById<TextView>(R.id.date1)
//var date2 = itemView.findViewById<TextView>(R.id.date2)
//var imagePath = itemView.findViewById<TextView>(R.id.imagePath2)