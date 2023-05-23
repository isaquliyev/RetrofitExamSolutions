package com.example.exam2305task1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam2305task1.R
import com.example.exam2305task1.model.JackReacher
import com.example.exam2305task1.model.Parameters
import com.squareup.picasso.Picasso

class Adapter(list: JackReacher, val listener : OnItemClickListener ) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var list: JackReacher

    init {
        this.list = list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var originalTitle = itemView.findViewById<TextView>(R.id.originalTitleId)
        var popularity = itemView.findViewById<TextView>(R.id.popularity)
        var releaseDate = itemView.findViewById<TextView>(R.id.releaseDateId)
        var posterPath = itemView.findViewById<ImageView>(R.id.posterPathId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.recycler_view_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.originalTitle.setText(list.results.get(position).original_title)
        holder.popularity.setText(list.results.get(position).popularity.toString())
        holder.releaseDate.setText(list.results.get(position).release_date)
        holder.originalTitle.setOnClickListener {
            listener.OnItemClick(list.results.get(position))
        }
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500${list.results.get(position).poster_path}")
            .into(holder.posterPath)

    }
}

interface OnItemClickListener{
    fun OnItemClick(item: Parameters)
}