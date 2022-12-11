package com.example.cloudmusic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cloudmusic.adapters.SlideShowAdapter
import com.example.cloudmusic.beans.SlideShowItem
import com.example.cloudmusic.databinding.FragmentNavFindBinding
import com.youth.banner.indicator.CircleIndicator

class NavFindFragment : Fragment() {
  private lateinit var binding: FragmentNavFindBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = FragmentNavFindBinding.inflate(layoutInflater, container, false)
    if (savedInstanceState == null) {
      createBanner()
    }
    return binding.root
  }

  private fun createBanner() {
    binding.banner.addBannerLifecycleObserver(this).setAdapter(
      SlideShowAdapter(
        listOf(
          SlideShowItem("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/1f28377c4236841c7294ae68c88e5af6.jpg?w=2452&h=920"),
          SlideShowItem("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/e89200db5385ff3d99fb45cc342fcd14.jpg?thumb=1&w=1533&h=575&f=webp&q=90")
        ), this
      )
    ).indicator = CircleIndicator(context);
  }
}