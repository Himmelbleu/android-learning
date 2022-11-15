package com.example.shopping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopping.adapters.CustomAdapter;
import com.example.shopping.R;

public class HomeFragment extends Fragment {

  private final String[] data = {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View inflate = inflater.inflate(R.layout.fragment_home, container, false);
    RecyclerView rv = inflate.findViewById(R.id.recycler_view);
    CustomAdapter ca = new CustomAdapter(data);
    rv.setAdapter(ca);
    LinearLayoutManager manager = new LinearLayoutManager(getActivity());
    rv.setLayoutManager(manager);
    return inflate;
  }

}