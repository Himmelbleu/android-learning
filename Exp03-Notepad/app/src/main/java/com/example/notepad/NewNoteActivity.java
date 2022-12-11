package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.notepad.databinding.ActivityNewNoteBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewNoteActivity extends AppCompatActivity {

  private ActivityNewNoteBinding _l;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    _l = ActivityNewNoteBinding.inflate(getLayoutInflater());
    setContentView(_l.getRoot());

    NoteHelper helper = new NoteHelper(this, "notes", null, 1);

    _l.newNoteSave.setOnClickListener(v -> {
      Note note = new Note();
      note.setContent(String.valueOf(_l.newNoteContent.getText()));
      note.setTitle(String.valueOf(_l.newNoteTitle.getText()));
      note.setDate(new SimpleDateFormat("yyyy-mm-dd").format(new Date().getTime()));
      helper.insert(note);
    });
  }

}