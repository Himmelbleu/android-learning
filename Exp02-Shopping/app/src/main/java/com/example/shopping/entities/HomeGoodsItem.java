package com.example.shopping.entities;

import java.io.Serializable;

public class HomeGoodsItem implements Serializable {
  private int id;
  private String imageSrc;
  private String title;
  private String content;
  private int price;

  public HomeGoodsItem(String imageSrc, String title, String content, int price) {
    this.imageSrc = imageSrc;
    this.title = title;
    this.content = content;
    this.price = price;
  }

  public HomeGoodsItem() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImageSrc() {
    return imageSrc;
  }

  public void setImageSrc(String imageSrc) {
    this.imageSrc = imageSrc;
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

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
