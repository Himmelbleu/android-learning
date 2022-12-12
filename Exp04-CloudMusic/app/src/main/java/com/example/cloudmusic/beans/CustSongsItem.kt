package com.example.cloudmusic.beans

class CustSongsItem {
  var url: String = ""
  var text: String = ""
  var author: String = ""

  constructor()

  constructor(url: String, text: String, author: String) : this() {
    this.url = url
    this.text = text
    this.author = author
  }

  override fun toString(): String {
    return "CustSongsItem(url='$url', text='$text', author='$author')"
  }
}