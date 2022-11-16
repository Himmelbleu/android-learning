package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.entities.HomeGoodsItem;

public class GoodsDetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_goods_detail);

    Intent intent = getIntent();
    Bundle bundle = intent.getExtras();
    HomeGoodsItem goodsItem = (HomeGoodsItem) bundle.getSerializable("GoodsItem");

    ImageView imageView = findViewById(R.id.goods_detail_cover);
    Glide.with(this).load(goodsItem.getImageSrc()).into(imageView);

    TextView priceText = findViewById(R.id.goods_detail_price);
    priceText.setText("￥" + goodsItem.getPrice());

    TextView titleText = findViewById(R.id.goods_detail_title);
    titleText.setText(goodsItem.getTitle());

    TextView contentText = findViewById(R.id.goods_detail_content);
    contentText.setText(goodsItem.getContent());
  }

}