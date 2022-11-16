package com.example.shopping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.adapters.HomeGoodsListAdapter;
import com.example.shopping.R;
import com.example.shopping.adapters.HomeTopSlideShowAdapter;
import com.example.shopping.entities.HomeGoodsItem;
import com.example.shopping.entities.HomeClassifyItem;
import com.example.shopping.entities.HomeSlideShowItem;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

  private final HomeGoodsItem[] goods;
  private final ArrayList<HomeSlideShowItem> banners;
  private final HomeClassifyItem[] homeClassifies;

  public HomeFragment() {
    banners = new ArrayList<>();
    banners.add(new HomeSlideShowItem("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/1f28377c4236841c7294ae68c88e5af6.jpg?w=2452&h=920"));
    banners.add(new HomeSlideShowItem("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/e89200db5385ff3d99fb45cc342fcd14.jpg?thumb=1&w=1533&h=575&f=webp&q=90"));
    banners.add(new HomeSlideShowItem("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/34ee703098b12753b2130a3462ca33ac.jpg?thumb=1&w=1533&h=575&f=webp&q=90"));

    goods = new HomeGoodsItem[]{
      new HomeGoodsItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1656916272.28414680.png", "Xiaomi 12S Pro", "骁龙8+ 旗舰处理器 ", 5099),
      new HomeGoodsItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1660117297.65685839.png", "Redmi K50 至尊版", "晓龙8+，1.5K定制直屏 超清分辨率", 2999),
      new HomeGoodsItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/963E7D67BDC0C743D3DA5B4C799347EE.png", "Redmi G 游戏本 锐龙版 R5", "Redmi G 游戏本 锐龙版 R5", 6299),
      new HomeGoodsItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1666798004.77398076.png", "Redmi Note 12 Pro", "IMX766+OIS光学防抖", 1699),
      new HomeGoodsItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1666797744.46462530.png", "Redmi Note 12 Pro+", "2亿超清相机，光学防抖", 2199),
      new HomeGoodsItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1664192136.00276876.png", "Xiaomi Civi 2", "第一代骁龙7移动平台", 2399),
      new HomeGoodsItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1666842735.73611426.png", "Xiaomi Book Air 13", "薄至约12mm 时尚超薄", 5199),
      new HomeGoodsItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1656916095.71929521.png", "Xiaomi 12S Ultra", "徕卡专业光学镜头", 5999),
    };

    homeClassifies = new HomeClassifyItem[]{
      new HomeClassifyItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1656673888.59622325.png", "小米上新"),
      new HomeClassifyItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1656916095.70948543.png", "手机"),
      new HomeClassifyItem("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/3d47879ec183e25a36e67e0219636e60.jpg?thumb=1&w=293&h=375&f=webp&q=90", "小米发布"),
      new HomeClassifyItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1628162373.00133777.jpg", "电视"),
      new HomeClassifyItem("https://cdn.cnbj1.fds.api.mi-img.com/nr-pub/202210241109_a0be0f18375219a87ffd0ae36e49d277.png", "空冰洗"),
      new HomeClassifyItem("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/609d0a457c7f8ac27d76f953c8acb7fc.jpg?thumb=1&w=250&h=250&f=webp&q=90", "小金商城"),
      new HomeClassifyItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1560510426.98522616.jpg", "小米众筹"),
      new HomeClassifyItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1666753567.54218064.png", "电脑/平板"),
      new HomeClassifyItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1585735675.4495923.jpg", "生活电器"),
      new HomeClassifyItem("https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1617024738.06472917.jpg", "智能家居"),
    };
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View inflate = inflater.inflate(R.layout.fragment_home, container, false);

    // 创建顶部 Banner
    Banner banner = inflate.findViewById(R.id.banner);
    banner.addBannerLifecycleObserver(this).setAdapter(new HomeTopSlideShowAdapter(banners, this)).setIndicator(new CircleIndicator(getContext()));

    // 创建分类列表
    setGridLayoutImageSrc(inflate);

    // 创建底部列表
    RecyclerView view = inflate.findViewById(R.id.recycler_view);
    HomeGoodsListAdapter adapter = new HomeGoodsListAdapter(goods, this);
    view.setAdapter(adapter);
    StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    view.setLayoutManager(manager);

    return inflate;
  }

  private void setGridLayoutImageSrc(View inflate) {
    ViewGroup parentGroup = inflate.findViewById(R.id.classifies_container);
    ImageView imageView;
    for (int i = 0; i < parentGroup.getChildCount(); i++) {
      ViewGroup childGroup = (ViewGroup) parentGroup.getChildAt(i);
      for (int j = 0; j < childGroup.getChildCount(); j++) {
        if (childGroup.getChildAt(j) instanceof ImageView) {
          imageView = (ImageView) childGroup.getChildAt(j);
          Glide.with(this).load(homeClassifies[i].getImageUrl()).into(imageView);
        }
      }
    }
  }

  private void createClassifyList(View inflate) {
    GridLayout gridLayout = inflate.findViewById(R.id.classifies_container);
    List<LinearLayout> layoutList = new ArrayList<>();

    for (HomeClassifyItem homeClassifyItem : homeClassifies) {
      LinearLayout linearLayout = new LinearLayout(getContext());
      linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
      linearLayout.setVerticalGravity(Gravity.CENTER_VERTICAL);
      linearLayout.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);
      linearLayout.setOrientation(LinearLayout.VERTICAL);

      ImageView imageView = new ImageView(getContext());
      imageView.setLayoutParams(new ViewGroup.LayoutParams(50, 50));
      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
      Glide.with(this).load(homeClassifyItem.getImageUrl()).into(imageView);

      linearLayout.addView(imageView);

      TextView textView = new TextView(getContext());
      textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
      textView.setText(homeClassifyItem.getLabel());

      linearLayout.addView(textView);

      layoutList.add(linearLayout);
    }

    addGridLayoutView(gridLayout, layoutList);
  }

  private void addGridLayoutView(GridLayout gridLayout, List<LinearLayout> layoutList) {
    int count = 0;

    for (int i = 0; i < gridLayout.getRowCount(); i++) {
      GridLayout.Spec row = GridLayout.spec(i, 1, GridLayout.FILL);

      for (int j = 0; j < gridLayout.getColumnCount(); j++) {
        GridLayout.Spec col = GridLayout.spec(j, 1, GridLayout.FILL);

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.rowSpec = row;
        layoutParams.columnSpec = col;
        layoutParams.setGravity(Gravity.CENTER);

        gridLayout.addView(layoutList.get(count++), layoutParams);
      }
    }
  }

}