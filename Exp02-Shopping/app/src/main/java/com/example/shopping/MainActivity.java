package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.shopping.fragments.CartFragment;
import com.example.shopping.fragments.HomeFragment;
import com.example.shopping.fragments.MyFragment;
import com.example.shopping.utils.SimpleEvent;

public class MainActivity extends AppCompatActivity {

  private FragmentManager fm;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SimpleEvent e = new SimpleEvent(MainActivity.this);

    fm = getSupportFragmentManager();

    FragmentTransaction initFt = fm.beginTransaction();
    initFt.replace(R.id.home_init_layout, new HomeFragment());
    initFt.addToBackStack(null);
    initFt.commit();

    e.set(view -> {
      FragmentTransaction ft = fm.beginTransaction();
      ft.replace(R.id.home_init_layout, new HomeFragment());
      ft.addToBackStack(null);
      ft.commit();
    }, R.id.nav_home);

    e.set(view -> {
      FragmentTransaction ft = fm.beginTransaction();
      ft.replace(R.id.home_init_layout, new CartFragment());
      ft.addToBackStack(null);
      ft.commit();
    }, R.id.nav_cart);

    e.set(view -> {
      FragmentTransaction ft = fm.beginTransaction();
      ft.replace(R.id.home_init_layout, new MyFragment());
      ft.addToBackStack(null);
      ft.commit();
    }, R.id.nav_my);
  }

}