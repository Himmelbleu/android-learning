package com.example.exp01_shopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.exp01_shopping.callbacks.Callback;
import com.example.exp01_shopping.fragments.TimePickerFragment;
import com.example.exp01_shopping.vms.TimePickerViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initSpinner();

    findViewById(R.id.time_picker_btn).setOnClickListener(this);
    findViewById(R.id.submit_btn).setOnClickListener(this);
  }

  private void initSpinner() {
    Spinner spinner = findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
      R.array.spinner_values, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
  }

  private void Log(String msg) {
    Log.d("Message", msg);
  }

  private void getChild(int layoutId, Callback cb) {
    ViewGroup view = findViewById(layoutId);
    CheckBox checkBox;
    for (int index = 0; index < view.getChildCount(); index++) {
      if (view.getChildAt(index) instanceof CheckBox) {
        checkBox = (CheckBox) view.getChildAt(index);
        if (checkBox.isChecked()) {
          cb.callback(checkBox.getText().toString(), index);
        }
      }
    }
  }

  @Override
  public void onClick(View view) {
    int viewId = view.getId();
    if (viewId == R.id.time_picker_btn) {
      TimePickerFragment timePicker = new TimePickerFragment();
      timePicker.show(getSupportFragmentManager(), "datePicker");
      TextView textview = findViewById(R.id.time_picker_text);
      // 观察 ViewModel 数据变化以更新 UI
      TimePickerViewModel timePickerVM = new ViewModelProvider(this).get(TimePickerViewModel.class);
      timePickerVM.getDateValue().observe(this, e -> {
        textview.setText(timePickerVM.getDateValue().getValue());
      });
    } else if (viewId == R.id.submit_btn) {
      // 1. 获取问题1的值
      RadioGroup rg = findViewById(R.id.radio_group);
      RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
      String ques1 = rb.getText().toString();
      Log("问题1 -> " + ques1);
      // 2. 获取问题2的值
      getChild(R.id.ques2_layout, new Callback() {
        @Override
        public void callback(String value, int index) {
          Log("问题2 -> " + "(第" + index + "项)" + value);
        }
      });
      // 3. 获取问题3的值
      getChild(R.id.ques3_layout, new Callback() {
        @Override
        public void callback(String value, int index) {
          Log("问题3 -> " + "(第" + index + "项)" + value);
        }
      });
      // 4. 获取问题4的值
      EditText ques4 = findViewById(R.id.ques4_edit_text);
      Log("问题4 -> " + ques4.getText().toString());
      // 5. 获取问题5的值
      EditText ques5 = findViewById(R.id.ques5_edit_text);
      Log("问题5 -> " + ques5.getText().toString());
      // 6. 获取问题6的值
      TextView ques6 = findViewById(R.id.time_picker_text);
      Log("问题6 -> " + ques6.getText().toString());
    }
  }
}