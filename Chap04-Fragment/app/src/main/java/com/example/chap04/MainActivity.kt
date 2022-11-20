package com.example.chap04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity(R.layout.activity_main) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (savedInstanceState == null) {

      val viewPager = findViewById<ViewPager2>(R.id.view_pager2)
      val fragments = listOf(IndexFragment(), DynamicFragment(), PersonFragment())
      viewPager.adapter = ViewPage2Adapter(this, fragments)

      findViewById<TextView>(R.id.nav_index).setOnClickListener {
//        supportFragmentManager
//          .beginTransaction()
//          .setReorderingAllowed(true)
//          .replace(R.id.fragment_container_view, IndexFragment().javaClass, null)
//          .commit()
      }

      findViewById<TextView>(R.id.nav_dynamic).setOnClickListener {
//        supportFragmentManager
//          .beginTransaction()
//          .setReorderingAllowed(true)
//          .replace(R.id.fragment_container_view, DynamicFragment().javaClass, null)
//          .commit()
      }

      findViewById<TextView>(R.id.nav_person).setOnClickListener {
//        supportFragmentManager
//          .beginTransaction()
//          .setReorderingAllowed(true)
//          .replace(R.id.fragment_container_view, PersonFragment().javaClass, null)
//          .commit()
      }
    }

  }

}