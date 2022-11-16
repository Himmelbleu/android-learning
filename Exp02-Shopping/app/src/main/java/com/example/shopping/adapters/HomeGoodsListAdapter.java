package com.example.shopping.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.GoodsDetailActivity;
import com.example.shopping.R;
import com.example.shopping.entities.HomeGoodsItem;

public class HomeGoodsListAdapter extends RecyclerView.Adapter<HomeGoodsListAdapter.ViewHolder> {

  private final Fragment fragment;
  private final HomeGoodsItem[] dataSet;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView goodsPrice;
    private final TextView goodsTitle;
    private final TextView goodsContent;
    private final ImageView goodsImage;

    public ViewHolder(View view) {
      super(view);
      goodsPrice = view.findViewById(R.id.goods_price);
      goodsImage = view.findViewById(R.id.goods_img);
      goodsTitle = view.findViewById(R.id.goods_title);
      goodsContent = view.findViewById(R.id.goods_content);
    }

    public TextView getGoodsPrice() {
      return goodsPrice;
    }

    public ImageView getGoodsImage() {
      return goodsImage;
    }

    public TextView getGoodsTitle() {
      return goodsTitle;
    }

    public TextView getGoodsContent() {
      return goodsContent;
    }
  }

  public HomeGoodsListAdapter(HomeGoodsItem[] dataSet, Fragment fragment) {
    this.dataSet = dataSet;
    this.fragment = fragment;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup group, int type) {
    View inflate = LayoutInflater.from(group.getContext()).inflate(R.layout.homeslice_goods_item, group, false);
    return new ViewHolder(inflate);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    Glide.with(fragment).load(dataSet[position].getImageSrc()).into(holder.getGoodsImage());
    holder.getGoodsTitle().setText(dataSet[position].getTitle());
    holder.getGoodsContent().setText(dataSet[position].getContent());
    holder.getGoodsPrice().setText("￥" + dataSet[position].getPrice() + "");

    holder.itemView.setOnClickListener((view) -> {
      Intent intent = new Intent(fragment.getContext(), GoodsDetailActivity.class);
      Bundle bundle = new Bundle();
      bundle.putSerializable("GoodsItem", dataSet[position]);
      intent.putExtras(bundle);
      fragment.startActivity(intent);
    });
  }

  @Override
  public int getItemCount() {
    return dataSet.length;
  }
}

