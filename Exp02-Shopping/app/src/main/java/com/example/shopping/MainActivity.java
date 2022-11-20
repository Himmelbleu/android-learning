package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.shopping.adapters.TabBarFragmentAdapter;
import com.example.shopping.fragments.CartFragment;
import com.example.shopping.fragments.HomeFragment;
import com.example.shopping.fragments.MyFragment;
import com.example.shopping.utils.SimpleEvent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ViewPager2 viewPager2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {
      viewPager2 = findViewById(R.id.view_pager2);
      SimpleEvent event = new SimpleEvent(MainActivity.this);
      List<Fragment> fragments = new ArrayList<>();
      fragments.add(new HomeFragment());
      fragments.add(new CartFragment());
      fragments.add(new MyFragment());

      viewPager2.setAdapter(new TabBarFragmentAdapter(MainActivity.this, fragments));
      findViewById(R.id.nav_home).setBackgroundResource(R.color.selected);

      event.set(view -> {
        findViewById(R.id.nav_cart).setBackgroundResource(R.color.white);
        findViewById(R.id.nav_my).setBackgroundResource(R.color.white);
        viewPager2.setCurrentItem(0);
        findViewById(R.id.nav_home).setBackgroundResource(R.color.selected);
      }, R.id.nav_home);

      event.set(view -> {
        findViewById(R.id.nav_home).setBackgroundResource(R.color.white);
        findViewById(R.id.nav_my).setBackgroundResource(R.color.white);
        viewPager2.setCurrentItem(1);
        findViewById(R.id.nav_cart).setBackgroundResource(R.color.selected);
      }, R.id.nav_cart);

      event.set(view -> {
        findViewById(R.id.nav_cart).setBackgroundResource(R.color.white);
        findViewById(R.id.nav_home).setBackgroundResource(R.color.white);
        viewPager2.setCurrentItem(2);
        findViewById(R.id.nav_my).setBackgroundResource(R.color.selected);
      }, R.id.nav_my);
    }
  }

}