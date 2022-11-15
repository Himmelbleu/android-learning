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
    new Goods("https://img1.baidu.com/it/u=325265706,3506901373&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=888", "Xiaomi MIX 4", "CUP全面屏", 4199),
    new Goods("https://img2.baidu.com/it/u=2626651686,1804871229&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=889", "Redmi K50 至尊版", "晓龙8+，1.5K定制直屏 超清分辨率", 2999),
    new Goods("https://img2.baidu.com/it/u=3370966475,2648114783&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=980", "Redmi Note 12 Pro+", "2亿超清相机，光学防抖", 2199),
    new Goods("https://img1.baidu.com/it/u=2825548117,2799986679&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=889", "Redmi Note 12 Pro", "IMX766+OIS光学防抖", 1699),
    new Goods("https://img1.baidu.com/it/u=1314367412,1534191342&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=774", "Xiaomi Civi 2", "好轻好薄好手感，一触生情", 2399),
    new Goods("https://img1.baidu.com/it/u=4150680579,1718130717&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=707", "Xiaomi 12S Ultra", "徕卡专业光学镜头", 5999),
    new Goods("https://img1.baidu.com/it/u=4150680579,1718130717&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=707", "Xiaomi 12S Ultra", "徕卡专业光学镜头", 5999),
    new Goods("https://img1.baidu.com/it/u=4150680579,1718130717&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=707", "Xiaomi 12S Ultra", "徕卡专业光学镜头", 5999),
    new Goods("https://img1.baidu.com/it/u=4150680579,1718130717&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=707", "Xiaomi 12S Ultra", "徕卡专业光学镜头", 5999),
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