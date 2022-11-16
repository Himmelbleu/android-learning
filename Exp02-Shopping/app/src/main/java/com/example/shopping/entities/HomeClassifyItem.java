package com.example.shopping.entities;

import java.io.Serializable;

public class HomeClassifyItem implements Serializable {

  private String imageUrl;
  private String label;

  public HomeClassifyItem(String imageUrl, String label) {
    this.imageUrl = imageUrl;
    this.label = label;
  }

  public HomeClassifyItem() {
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }
}
