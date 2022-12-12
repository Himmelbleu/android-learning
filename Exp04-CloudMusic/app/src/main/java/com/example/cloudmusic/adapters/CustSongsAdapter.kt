package com.example.cloudmusic.adapters

import android.content.Context
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
import com.example.cloudmusic.beans.CustSongsItem

class CustSongsAdapter(
  private var initList: ArrayList<CustSongsItem>,
  private var content: Context
) : RecyclerView.Adapter<CustSongsAdapter.CustSongsViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustSongsViewHolder {
    return CustSongsViewHolder(LayoutInflater.from(content).inflate(R.layout.item_cust_songs, parent, false))
  }

  override fun onBindViewHolder(holder: CustSongsViewHolder, position: Int) {
    val options = RequestOptions.bitmapTransform(RoundedCorners(30))
    Glide.with(content).load(initList[position].url).apply(options).into(holder.imageView)
    holder.textView.text = initList[position].text
    holder.authorTextView.text = initList[position].author
  }

  override fun getItemCount(): Int {
    return initList.size
  }

  class CustSongsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var imageView: ImageView = view.findViewById(R.id.surface)
    var textView: TextView = view.findViewById(R.id.text)
    var authorTextView: TextView = view.findViewById(R.id.author)
  }
}