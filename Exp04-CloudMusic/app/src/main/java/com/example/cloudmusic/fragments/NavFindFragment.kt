package com.example.cloudmusic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudmusic.adapters.CustSongsAdapter
import com.example.cloudmusic.adapters.RecoSongsAdapter
import com.example.cloudmusic.adapters.SlideShowAdapter
import com.example.cloudmusic.beans.CustSongsItem
import com.example.cloudmusic.beans.RecoSongsItem
import com.example.cloudmusic.beans.SlideShowItem
import com.example.cloudmusic.databinding.FragmentNavFindBinding
import com.youth.banner.indicator.CircleIndicator

class NavFindFragment : Fragment() {
  private lateinit var binding: FragmentNavFindBinding
  private lateinit var recoSongsAdapter: RecoSongsAdapter
  private lateinit var custSongsAdapter: CustSongsAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = FragmentNavFindBinding.inflate(layoutInflater, container, false)
    if (savedInstanceState == null) {
      createBanner()
      createRecoSongs()
      createCustSongs()
    }
    return binding.root
  }

  private fun createBanner() {
    binding.banner.addBannerLifecycleObserver(this).setAdapter(
      SlideShowAdapter(
        listOf(
          SlideShowItem("https://p1.music.126.net/HmOx_IuQqffXCloVq2YzTA==/109951168139555566.jpg?imageView&quality=89"),
          SlideShowItem("https://p1.music.126.net/d7co9jgMW99Vwt3fsdzhZQ==/109951168139553832.jpg?imageView&quality=89"),
          SlideShowItem("https://p1.music.126.net/UuSd71D8bonCDUJYdp7avQ==/109951168139528689.jpg?imageView&quality=89")
        ), this
      )
    ).indicator = CircleIndicator(context);
  }

  private fun createRecoSongs() {
    binding.recoSongsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, true)
    recoSongsAdapter = RecoSongsAdapter(
      arrayListOf(
        RecoSongsItem("https://p2.music.126.net/SyerXTn8Np6646rabTS8EA==/109951163046604560.jpg?param=130y130", "Funny Logic"),
        RecoSongsItem("https://p2.music.126.net/SyerXTn8Np6646rabTS8EA==/109951163046604560.jpg?param=130y130", "Funny Logic"),
        RecoSongsItem("https://p2.music.126.net/SyerXTn8Np6646rabTS8EA==/109951163046604560.jpg?param=130y130", "Funny Logic"),
        RecoSongsItem("https://p2.music.126.net/SyerXTn8Np6646rabTS8EA==/109951163046604560.jpg?param=130y130", "Funny Logic"),
      ), requireContext()
    )
    binding.recoSongsRecyclerView.adapter = recoSongsAdapter
  }

  private fun createCustSongs() {
    binding.custSongsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, true)
    custSongsAdapter = CustSongsAdapter(
      arrayListOf(
        CustSongsItem("https://p2.music.126.net/SyerXTn8Np6646rabTS8EA==/109951163046604560.jpg?param=130y130", "Funny Logic", "Author"),
        CustSongsItem("https://p2.music.126.net/SyerXTn8Np6646rabTS8EA==/109951163046604560.jpg?param=130y130", "Funny Logic", "Author"),
        CustSongsItem("https://p2.music.126.net/SyerXTn8Np6646rabTS8EA==/109951163046604560.jpg?param=130y130", "Funny Logic", "Author"),
        CustSongsItem("https://p2.music.126.net/SyerXTn8Np6646rabTS8EA==/109951163046604560.jpg?param=130y130", "Funny Logic", "Author"),
        CustSongsItem("https://p2.music.126.net/SyerXTn8Np6646rabTS8EA==/109951163046604560.jpg?param=130y130", "Funny Logic", "Author"),
      ), requireContext()
    )
    binding.custSongsRecyclerView.adapter = custSongsAdapter
  }
}