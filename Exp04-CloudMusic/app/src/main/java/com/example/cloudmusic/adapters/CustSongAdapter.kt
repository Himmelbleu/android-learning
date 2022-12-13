package com.example.cloudmusic.adapters

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
import com.example.cloudmusic.PlayerActivity
import com.example.cloudmusic.R
import com.example.cloudmusic.beans.Song

class CustSongAdapter(
  private var sources: ArrayList<Song>,
  private var content: Context
) : RecyclerView.Adapter<CustSongAdapter.CustSongViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustSongViewHolder {
    return CustSongViewHolder(LayoutInflater.from(content).inflate(R.layout.item_cust_songs, parent, false))
  }

  override fun onBindViewHolder(holder: CustSongViewHolder, position: Int) {
    val options = RequestOptions.bitmapTransform(RoundedCorners(30))
    Glide.with(content).load(sources[position].surface).apply(options).into(holder.surfaceView)
    holder.textView.text = sources[position].text
    holder.authorTextView.text = sources[position].author

    holder.itemView.setOnClickListener {
      val intent = Intent(content, PlayerActivity().javaClass)
      val bundle = Bundle()
      bundle.putSerializable("song", sources[position])
      intent.putExtras(bundle)
      content.startActivity(intent)
    }
  }

  override fun getItemCount(): Int {
    return sources.size
  }

  class CustSongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var surfaceView: ImageView = view.findViewById(R.id.surface)
    var textView: TextView = view.findViewById(R.id.text)
    var authorTextView: TextView = view.findViewById(R.id.author)
  }
}