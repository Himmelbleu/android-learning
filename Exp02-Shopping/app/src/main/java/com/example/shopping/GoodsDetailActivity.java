package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.shopping.entities.HomeGoodsItem;

public class GoodsDetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_goods_detail);

    Intent intent = getIntent();
    Bundle extras = intent.getExtras();
    HomeGoodsItem goodsItem = (HomeGoodsItem) extras.getSerializable("GoodsItem");
    Log.d("Test", goodsItem.getTitle());
  }

}