package com.example.cloudmusic.beans

import org.litepal.crud.DataSupport
import java.io.Serializable

class Songs : Serializable, DataSupport {
  var id: Int = 0
  var surface: String = ""
  var text: String = ""
  var list: ArrayList<Song> = arrayListOf()

  constructor()

  constructor(url: String, text: String) {
    this.surface = url
    this.text = text
  }

  override fun toString(): String {
    return "Songs(id=$id, surface='$surface', text='$text', list=$list)"
  }
}