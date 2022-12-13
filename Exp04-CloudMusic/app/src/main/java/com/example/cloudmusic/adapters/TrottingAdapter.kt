package com.example.cloudmusic.adapters

import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloudmusic.beans.Trotting
import com.youth.banner.adapter.BannerAdapter

class TrottingAdapter(
  shows: List<Trotting>,
  private var fragment: Fragment
) : BannerAdapter<Trotting, TrottingAdapter.SlideShowViewHolder>(shows) {

  override fun onCreateHolder(parent: ViewGroup?, viewType: Int): SlideShowViewHolder {
    val imageView = ImageView(parent!!.context)
    imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    return SlideShowViewHolder(imageView)
  }

  override fun onBindView(holder: SlideShowViewHolder?, data: Trotting?, position: Int, size: Int) {
    Glide.with(fragment).load(mDatas[position].url).into(holder!!.imageView)
  }

  class SlideShowViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(imageView) {
    init {
      imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    }
  }
}