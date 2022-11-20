package com.example.chap04

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPage2Adapter(fragmentActivity: FragmentActivity, fragments: List<Fragment>) : FragmentStateAdapter(fragmentActivity) {

  private var fragments: List<Fragment>

  init {
    this.fragments = fragments
  }

  override fun getItemCount(): Int {
    return fragments.size
  }

  override fun createFragment(position: Int): Fragment {
    return fragments[position]
  }



}