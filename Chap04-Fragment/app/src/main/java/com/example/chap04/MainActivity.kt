package com.example.chap04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity(R.layout.activity_main) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (savedInstanceState == null) {
      val navBars = listOf<TextView>(findViewById(R.id.nav_index), findViewById(R.id.nav_dynamic), findViewById(R.id.nav_person))
      val fragments = listOf(IndexFragment(), DynamicFragment(), PersonFragment())
      val pager = findViewById<ViewPager2>(R.id.view_pager2)
      pager.adapter = ViewPage2Adapter(this, fragments)

      var lastPosition = 0
      pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(currPosition: Int) {
          navBars[lastPosition].setBackgroundResource(R.color.white)
          navBars[currPosition].setBackgroundResource(R.color.nav_selected)
          lastPosition = currPosition
        }
      })

      navBars[0].setOnClickListener {
        Log.d("Test", pager.currentItem.toString())
        pager.currentItem = 0
      }

      navBars[1].setOnClickListener {
        pager.currentItem = 1
      }

      navBars[2].setOnClickListener {
        pager.currentItem = 2
      }
    }
  }

}