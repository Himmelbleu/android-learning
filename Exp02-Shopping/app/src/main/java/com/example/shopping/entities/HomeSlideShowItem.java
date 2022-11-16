package com.example.shopping.entities;

import java.io.Serializable;

public class HomeSlideShowItem implements Serializable {
  private String url;

  public HomeSlideShowItem() {
  }

  public HomeSlideShowItem(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
