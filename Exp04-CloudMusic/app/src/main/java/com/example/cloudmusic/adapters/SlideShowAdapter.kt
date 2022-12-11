package com.example.cloudmusic.adapters

import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cloudmusic.beans.SlideShowItem
import com.youth.banner.adapter.BannerAdapter

class SlideShowAdapter(
  banners: List<SlideShowItem>,
  private var fragment: Fragment
) : BannerAdapter<SlideShowItem, SlideShowAdapter.SlideShowViewHolder>(banners) {

  override fun onCreateHolder(parent: ViewGroup?, viewType: Int): SlideShowViewHolder {
    val imageView = ImageView(parent!!.context)
    imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    return SlideShowViewHolder(imageView)
  }

  override fun onBindView(holder: SlideShowViewHolder?, data: SlideShowItem?, position: Int, size: Int) {
    Glide.with(fragment).load(mDatas[position].url).into(holder!!.imageView)
  }

  class SlideShowViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(imageView) {
    init {
      imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    }
  }
}