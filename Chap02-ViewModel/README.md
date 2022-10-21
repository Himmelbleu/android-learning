# 学习目的

初步认识 ViewModel，知道一两个使用场景。

ViewModel 旨在以注重生命周期的方式存储和管理界面相关数据。ViewModel 让数据可在发生屏幕旋转等配置更改后继续留存。

# ViewModel 的基本形式

```java
public class TimePickerViewModel extends ViewModel {
  private MutableLiveData<String> dateValue;

  public LiveData<String> getDateValue() {
    if (dateValue == null) {
      dateValue = new MutableLiveData<>();
    }
    return dateValue;
  }

  public void setDateValue(String dateValue) {
    this.dateValue.setValue(dateValue);
  }
}
```

在给 ViewModel 字段注入数据时，使用的是 MutableLiveData 提供的`setValue`函数，而不是通过 `this.dateValue = dateValue`来注入数据。

# 使用 ViewModel

这个例子当中是在 Fragment 中使用的 ViewModel：

```java
public class TimePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

  // ......

  @Override
  public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
    TimePickerViewModel vm = new ViewModelProvider(requireActivity()).get(TimePickerViewModel.class);
    vm.setDateValue(i + "-" + i1 + "-" + i2);
  }
}
```

创建 ViewModelProvider，我们知道 ViewModel 属于一个 Activity，并且贯穿整个生命周期。所以，你需要获取这个 ViewModel 的持有者，也就是获取这个
Fragment 关联的 Activity ，通过`requireActivity`函数来获取 Activity。

# 观察 ViewModel

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  // ......
  
  @Override
  public void onClick(View view) {
    // ...
    TimePickerViewModel timePickerVM = new ViewModelProvider(this).get(TimePickerViewModel.class);
    timePickerVM.getDateValue().observe(this, e -> {
      textview.setText(timePickerVM.getDateValue().getValue());
    });
  }
}
```

获取对应的 ViewModel 对象，这里就是 TimePickerViewModel（ViewModel 的子类）。在 Fragment 当中选择日期之后已经存储了最新值。
在 Activity 中只需要观察 ViewModel 的变化，然后给 TextView 设置更新之后的值。