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

//    RecyclerView rv = findViewById(R.id.recycler_view);
//    CustomAdapter ca = new CustomAdapter(data);
//    LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
//    rv.setAdapter(ca);
//    rv.setLayoutManager(manager);

    SimpleEvent e = new SimpleEvent(MainActivity.this);

    fm = getSupportFragmentManager();

    e.set(view -> {
      FragmentTransaction ft = fm.beginTransaction();
      ft.replace(R.id.init_layout, new HomeFragment());
      ft.addToBackStack(null);
      ft.commit();
    }, R.id.home);

    e.set(view -> {
      FragmentTransaction fragmentTransaction = fm.beginTransaction();
      fragmentTransaction.replace(R.id.init_layout, new CartFragment());
      fragmentTransaction.addToBackStack(null);
      fragmentTransaction.commit();
    }, R.id.cart);

    e.set(view -> {
      FragmentTransaction fragmentTransaction = fm.beginTransaction();
      fragmentTransaction.replace(R.id.init_layout, new MyFragment());
      fragmentTransaction.addToBackStack(null);
      fragmentTransaction.commit();
    }, R.id.my);
  }

}