package com.example.cloudmusic.beans

import org.litepal.crud.DataSupport
import java.io.Serializable

class User : Serializable, DataSupport {
  var id: Int = 0;
  var username: String = ""
  var password: String = ""
  var signature: String = ""
  var level: Int = 0;
  var sex: String = ""
  var avatar: String = ""

  constructor()

  constructor(username: String, password: String, signature: String, level: Int, sex: String, avatar: String) : super() {
    this.username = username
    this.password = password
    this.signature = signature
    this.level = level
    this.sex = sex
    this.avatar = avatar
  }

  override fun toString(): String {
    return "User(id=$id, username='$username', password='$password', signature='$signature', level=$level, sex='$sex', avatar='$avatar')"
  }
}