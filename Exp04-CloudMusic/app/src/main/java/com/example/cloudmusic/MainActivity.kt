package com.example.cloudmusic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cloudmusic.adapters.BottomNavAdapter
import com.example.cloudmusic.databinding.ActivityMainBinding
import com.example.cloudmusic.fragments.NavFindFragment
import com.example.cloudmusic.fragments.NavPersonFragment

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    if (savedInstanceState == null) {
      createViewPage2()
    }
  }

  private fun createViewPage2() {
    binding.viewPage2.adapter = BottomNavAdapter(
      this, listOf(NavFindFragment(), NavPersonFragment())
    )

    binding.navHome.setOnClickListener {
      binding.viewPage2.currentItem = 0
    }

    binding.navMy.setOnClickListener {
      binding.viewPage2.currentItem = 1
    }
  }
}