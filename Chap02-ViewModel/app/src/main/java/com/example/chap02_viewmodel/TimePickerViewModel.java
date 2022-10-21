package com.example.chap02_viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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