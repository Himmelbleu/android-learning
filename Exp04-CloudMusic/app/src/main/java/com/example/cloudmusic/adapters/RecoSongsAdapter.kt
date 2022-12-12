package com.example.cloudmusic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloudmusic.R
import com.example.cloudmusic.beans.RecoSongsItem

class RecoSongsAdapter(
  private var data: List<RecoSongsItem>,
  private var content: Context
) : RecyclerView.Adapter<RecoSongsAdapter.RecoSongsViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecoSongsViewHolder {
    val view = LayoutInflater.from(content).inflate(R.layout.item_reco_songs, parent, false)
    return RecoSongsViewHolder(view)
  }

  override fun onBindViewHolder(holder: RecoSongsViewHolder, position: Int) {
    Glide.with(content).load(data[position].url).into(holder.imageView)
    holder.textView.text = data[position].text
  }

  override fun getItemCount(): Int {
    return data.size
  }

  class RecoSongsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var imageView: ImageView = view.findViewById(R.id.surface)
    var textView: TextView = view.findViewById(R.id.text)
  }
}