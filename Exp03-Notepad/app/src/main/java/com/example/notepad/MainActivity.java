package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.notepad.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding _l;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    _l = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(_l.getRoot());

    RecyclerView view = _l.view;
    NoteHelper helper = new NoteHelper(this, "notes", null, 1);
    NotesAdapter adapter = new NotesAdapter(helper.select(null, null));
    view.setAdapter(adapter);
    StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    view.setLayoutManager(manager);

    _l.addNote.setOnClickListener(v -> {
      Intent intent = new Intent(this, NewNoteActivity.class);
      startActivity(intent);
    });
  }

}