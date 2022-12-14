package com.example.cloudmusic.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.cloudmusic.LoginActivity
import com.example.cloudmusic.databinding.FragmentNavPersonBinding

class NavPersonFragment : Fragment() {
  private lateinit var binding: FragmentNavPersonBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = FragmentNavPersonBinding.inflate(layoutInflater, container, false)

    return binding.root
  }

  private fun inspect() {
    val prefs = activity?.getSharedPreferences("userCache", 0)
    val username = prefs?.getString("username", null)
    if (username !== null) {
      binding.username.text = username
      binding.signature.text = prefs.getString("signature", null)
      binding.level.text = "等级：${prefs.getString("level", null)}"
      Glide.with(this).load(prefs.getString("avatar", null))
        .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
        .into(binding.avatar)
    } else {
      binding.username.text = "你没有登录，点击登录"
      binding.signature.visibility = View.INVISIBLE;
      Toast.makeText(requireContext(), "你没有登录，请先登录！", Toast.LENGTH_SHORT).show()
      binding.user.setOnClickListener {
        startActivity(Intent(requireContext(), LoginActivity().javaClass))
      }
    }
  }

  override fun onResume() {
    super.onResume()
    inspect()
  }
}