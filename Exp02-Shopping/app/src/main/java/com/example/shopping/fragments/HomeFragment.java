package com.example.shopping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopping.adapters.GoodsAdapter;
import com.example.shopping.R;
import com.example.shopping.adapters.ImageAdapter;
import com.example.shopping.entities.Goods;
import com.example.shopping.entities.SlideShow;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

  private final Goods[] goods = {
    new Goods("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1656916272.28414680.png", "Xiaomi 12S Pro", "骁龙8+ 旗舰处理器 ", 5099),
    new Goods("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1660117297.65685839.png", "Redmi K50 至尊版", "晓龙8+，1.5K定制直屏 超清分辨率", 2999),
    new Goods("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/963E7D67BDC0C743D3DA5B4C799347EE.png", "Redmi G 游戏本 锐龙版 R5", "Redmi G 游戏本 锐龙版 R5", 6299),
    new Goods("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1666798004.77398076.png", "Redmi Note 12 Pro", "IMX766+OIS光学防抖", 1699),
    new Goods("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1666797744.46462530.png", "Redmi Note 12 Pro+", "2亿超清相机，光学防抖", 2199),
    new Goods("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1664192136.00276876.png", "Xiaomi Civi 2", "第一代骁龙7移动平台", 2399),
    new Goods("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1666842735.73611426.png", "Xiaomi Book Air 13", "薄至约12mm 时尚超薄", 5199),
    new Goods("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1656916095.71929521.png", "Xiaomi 12S Ultra", "徕卡专业光学镜头", 5999),
  };

  private static final ArrayList<SlideShow> banners;

  static {
    banners = new ArrayList<>();
    banners.add(new SlideShow("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/1f28377c4236841c7294ae68c88e5af6.jpg?w=2452&h=920"));
    banners.add(new SlideShow("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/e89200db5385ff3d99fb45cc342fcd14.jpg?thumb=1&w=1533&h=575&f=webp&q=90"));
    banners.add(new SlideShow("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/34ee703098b12753b2130a3462ca33ac.jpg?thumb=1&w=1533&h=575&f=webp&q=90"));
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View inflate = inflater.inflate(R.layout.fragment_home, container, false);
    RecyclerView view = inflate.findViewById(R.id.recycler_view);
    GoodsAdapter adapter = new GoodsAdapter(goods, this);
    view.setAdapter(adapter);
    StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    view.setLayoutManager(manager);
    Banner banner = inflate.findViewById(R.id.banner);
    banner.addBannerLifecycleObserver(this)
      .setAdapter(new ImageAdapter(banners, this))
      .setIndicator(new CircleIndicator(getContext()));
    return inflate;
  }

}