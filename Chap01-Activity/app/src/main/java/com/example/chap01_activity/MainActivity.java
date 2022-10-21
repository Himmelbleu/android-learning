package com.example.chap01_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  public static final String EXTRA_MESSAGE = "com.example.Message";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.routeButton).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    Intent intent = new Intent(this, MessageActivity.class);
    EditText editText = findViewById(R.id.editText);
    String message = editText.getText().toString();
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);
  }
}