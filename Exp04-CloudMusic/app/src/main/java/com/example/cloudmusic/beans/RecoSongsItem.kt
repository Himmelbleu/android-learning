package com.example.cloudmusic.beans

class RecoSongsItem() {
  var url: String = ""
  var text: String = ""

  constructor(url: String, text: String) : this() {
    this.url = url
    this.text = text
  }

  override fun toString(): String {
    return "RecoSongsItem(url='$url', text='$text')"
  }
}