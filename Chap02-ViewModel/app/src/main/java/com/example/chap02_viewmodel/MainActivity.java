package com.example.chap02_viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.time_picker_btn).setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    // 1. 实例化 TimePickerFragment
    TimePickerFragment timePicker = new TimePickerFragment();
    // 2. 显示日期选择器
    timePicker.show(getSupportFragmentManager(), "datePicker");
    // 3. 获取 TextView，展示的数据放在这里
    TextView textview = findViewById(R.id.time_picker_text);
    // 4. 观察 ViewModel 数据变化以更新 UI
    TimePickerViewModel timePickerVM = new ViewModelProvider(this).get(TimePickerViewModel.class);
    // 5. 观察数据变化
    timePickerVM.getDateValue().observe(this, e -> {
      // 6. 数据变化，把新的日期展示到 TextView 中
      textview.setText(timePickerVM.getDateValue().getValue());
    });
  }
}