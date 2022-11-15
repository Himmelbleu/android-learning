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
import com.example.shopping.entities.Goods;

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

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View inflate = inflater.inflate(R.layout.fragment_home, container, false);
    RecyclerView rv = inflate.findViewById(R.id.recycler_view);
    GoodsAdapter ca = new GoodsAdapter(goods, this);
    rv.setAdapter(ca);
    StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    rv.setLayoutManager(manager);
    return inflate;
  }

}