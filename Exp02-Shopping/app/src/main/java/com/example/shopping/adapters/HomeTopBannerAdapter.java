package com.example.shopping.adapters;

import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.entities.SlideShow;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class HomeTopBannerAdapter extends BannerAdapter<SlideShow, HomeTopBannerAdapter.BannerViewHolder> {

  private final Fragment fragment;

  public HomeTopBannerAdapter(List<SlideShow> banners, Fragment fragment) {
    super(banners);
    this.fragment = fragment;
  }

  @Override
  public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
    ImageView imageView = new ImageView(parent.getContext());
    imageView.setLayoutParams(new ViewGroup.LayoutParams(
      ViewGroup.LayoutParams.MATCH_PARENT,
      ViewGroup.LayoutParams.MATCH_PARENT));
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return new BannerViewHolder(imageView);
  }

  @Override
  public void onBindView(BannerViewHolder holder, SlideShow data, int position, int size) {
    Glide.with(fragment).load(mDatas.get(position).getUrl()).into(holder.imageView);
  }

  static class BannerViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public BannerViewHolder(@NonNull ImageView view) {
      super(view);
      this.imageView = view;
      imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
}
