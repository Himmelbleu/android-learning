package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  private final String[] data = {"1", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    RecyclerView rv = findViewById(R.id.recycler_view);
    CustomAdapter ca = new CustomAdapter(data);
    rv.setAdapter(ca);

    LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
    rv.setLayoutManager(manager);
  }

}