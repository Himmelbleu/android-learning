package com.example.cloudmusic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudmusic.adapters.CustSongAdapter
import com.example.cloudmusic.adapters.RecoSongsAdapter
import com.example.cloudmusic.adapters.TrottingAdapter
import com.example.cloudmusic.beans.Song
import com.example.cloudmusic.beans.Songs
import com.example.cloudmusic.beans.Trotting
import com.example.cloudmusic.databinding.FragmentNavFindBinding
import com.youth.banner.indicator.CircleIndicator
import org.litepal.crud.DataSupport

class NavFindFragment : Fragment() {
  private lateinit var binding: FragmentNavFindBinding
  private lateinit var recoSongsAdapter: RecoSongsAdapter
  private lateinit var custSongAdapter: CustSongAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    binding = FragmentNavFindBinding.inflate(layoutInflater, container, false)
    if (savedInstanceState == null) {
      createTrotting()
      createRecoSongs()
      createCustSong()
    }
    return binding.root
  }

  private fun createTrotting() {
    binding.banner.addBannerLifecycleObserver(this).setAdapter(
      TrottingAdapter(
        listOf(
          Trotting("https://p1.music.126.net/HmOx_IuQqffXCloVq2YzTA==/109951168139555566.jpg?imageView&quality=89"),
          Trotting("https://p1.music.126.net/d7co9jgMW99Vwt3fsdzhZQ==/109951168139553832.jpg?imageView&quality=89"),
          Trotting("https://p1.music.126.net/UuSd71D8bonCDUJYdp7avQ==/109951168139528689.jpg?imageView&quality=89")
        ), this
      )
    ).indicator = CircleIndicator(context)
  }

  private fun createRecoSongs() {
    binding.recoSongsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    val sources = DataSupport.findAll(Songs().javaClass) as ArrayList<Songs>
    recoSongsAdapter = RecoSongsAdapter(
      sources, requireContext()
    )
    binding.recoSongsRecyclerView.adapter = recoSongsAdapter
  }

  private fun createCustSong() {
    binding.custSongsRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3, RecyclerView.HORIZONTAL, false)
    val sources = DataSupport.findAll(Song().javaClass) as ArrayList<Song>
    custSongAdapter = CustSongAdapter(
      sources, requireContext()
    )
    binding.custSongsRecyclerView.adapter = custSongAdapter
  }
}