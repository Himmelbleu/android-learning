package com.example.cloudmusic.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.cloudmusic.LoginActivity
import com.example.cloudmusic.R
import com.example.cloudmusic.databinding.FragmentNavPersonBinding

class NavPersonFragment : Fragment() {
  private lateinit var binding: FragmentNavPersonBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = FragmentNavPersonBinding.inflate(layoutInflater, container, false)

    if (savedInstanceState == null) {
      binding.userCtl.setOnClickListener {
        activity?.getSharedPreferences("userCache", 0)?.edit()?.clear()?.apply()
        Toast.makeText(requireContext(), "登出成功！", Toast.LENGTH_SHORT).show()
        loadLogoutUI()
      }

      binding.likeMusics.setOnClickListener {

      }

      binding.recentMusics.setOnClickListener {

      }

      val prefs = activity?.getSharedPreferences("userCache", 0)
      if (prefs?.getString("username", null) == null) loadLogoutUI()
      else loadLoginUI(prefs)
    }

    return binding.root
  }

  private fun loadLogoutUI() {
    binding.user.setOnClickListener {
      startActivity(Intent(requireContext(), LoginActivity().javaClass))
    }
    binding.userCtl.visibility = View.INVISIBLE
    binding.level.visibility = View.INVISIBLE
    binding.avatar.setImageResource(R.mipmap.ic_launcher_round)
    binding.username.text = "你没有登录，点击登录"
    binding.signature.visibility = View.INVISIBLE
    Toast.makeText(requireContext(), "你没有登录，请先登录！", Toast.LENGTH_SHORT).show()
  }

  @SuppressLint("SetTextI18n")
  private fun loadLoginUI(prefs: SharedPreferences) {
    val username = prefs.getString("username", null)
    binding.username.text = username
    if (!TextUtils.isEmpty(username)) {
      binding.signature.text = prefs.getString("signature", null)
      binding.level.text = "等级：${prefs.getString("level", null)}"
      Glide.with(this).load(prefs.getString("avatar", null))
        .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
        .into(binding.avatar)
    }
  }

  private fun inspect() {
    val prefs = activity?.getSharedPreferences("userCache", 0)
    val username = prefs?.getString("username", null)
    if (username !== null) loadLoginUI(prefs)
    else loadLogoutUI()
  }

  override fun onResume() {
    super.onResume()
    inspect()
  }
}