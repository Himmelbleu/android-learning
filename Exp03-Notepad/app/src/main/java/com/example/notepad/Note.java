package com.example.notepad;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

  private String id;
  private String title;
  private String content;
  private String  date;

  public Note() {
  }

  public Note(String id, String title, String content, String date) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Note{" +
      "id='" + id + '\'' +
      ", title='" + title + '\'' +
      ", content='" + content + '\'' +
      ", date='" + date + '\'' +
      '}';
  }
}
