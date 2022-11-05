package com.example.exp01_shopping.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.exp01_shopping.vms.TimePickerViewModel;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    final Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);
    return new DatePickerDialog(getActivity(), this, year, month, day);
  }

  @Override
  public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
    TimePickerViewModel vm = new ViewModelProvider(requireActivity()).get(TimePickerViewModel.class);
    vm.setDateValue(i + "-" + i1 + "-" + i2);
  }
}
