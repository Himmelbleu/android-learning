package com.example.cloudmusic.beans

import org.litepal.crud.DataSupport
import java.io.Serializable

class Song : Serializable, DataSupport {
  var id: Int = 0
  var surface: String = ""
  var text: String = ""
  var author: String = ""
  var url: String = ""

  constructor()

  constructor(surface: String, text: String, author: String, url: String) {
    this.surface = surface
    this.text = text
    this.author = author
    this.url = url
  }

  override fun toString(): String {
    return "Song(id=$id, surface='$surface', text='$text', author='$author', url='$url')"
  }
}