package com.example.cloudmusic.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.cloudmusic.R
import com.example.cloudmusic.SongsActivity
import com.example.cloudmusic.beans.Songs

class RecoSongsAdapter(
  private var sources: ArrayList<Songs>,
  private var content: Context
) : RecyclerView.Adapter<RecoSongsAdapter.RecoSongsViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecoSongsViewHolder {
    return RecoSongsViewHolder(LayoutInflater.from(content).inflate(R.layout.item_reco_songs, parent, false))
  }

  override fun onBindViewHolder(holder: RecoSongsViewHolder, position: Int) {
    val options = RequestOptions.bitmapTransform(RoundedCorners(30))
    Glide.with(content).load(sources[position].surface).apply(options).into(holder.surfaceView)
    holder.textView.text = sources[position].text

    holder.itemView.setOnClickListener {
      val intent = Intent(content, SongsActivity().javaClass)
      val bundle = Bundle()
      bundle.putSerializable("songs", sources[position])
      intent.putExtras(bundle)
      content.startActivity(intent)
    }
  }

  override fun getItemCount(): Int {
    return sources.size
  }

  @SuppressLint("NotifyDataSetChanged")
  fun reset(newList: ArrayList<Songs>) {
    sources.clear()
    sources = newList
    notifyDataSetChanged()
  }

  class RecoSongsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var surfaceView: ImageView = view.findViewById(R.id.surface)
    var textView: TextView = view.findViewById(R.id.text)
  }
}