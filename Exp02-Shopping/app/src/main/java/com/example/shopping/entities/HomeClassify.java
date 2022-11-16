package com.example.shopping.entities;

public class HomeClassify {

  private String imageUrl;
  private String label;

  public HomeClassify(String imageUrl, String label) {
    this.imageUrl = imageUrl;
    this.label = label;
  }

  public HomeClassify() {
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
