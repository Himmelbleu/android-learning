package com.example.chap04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(R.layout.activity_main) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (savedInstanceState == null) {
      val bundle = Bundle()
      bundle.putInt("param", 20);
      supportFragmentManager
        .beginTransaction()
        .setReorderingAllowed(true)
        .add(R.id.fragment_container_view, IndexFragment().javaClass, bundle, null)
        .commit()
    }
  }

}