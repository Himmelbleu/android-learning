package com.example.notepad;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NoteHelper extends SQLiteOpenHelper {

  private final String sql = "CREATE TABLE notes (id integer primary key autoincrement, title text, content text, date text);";

  public NoteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
    super(context, name, factory, version);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(sql);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists notes");
    onCreate(db);
  }

  public Long insert(Note note) {
    ContentValues values = new ContentValues();
    values.put("title", note.getTitle());
    values.put("content", note.getContent());
    values.put("date", note.getDate());
    return getWritableDatabase().insert("notes", null, values);
  }

  @SuppressLint({"Range", "Recycle"})
  public ArrayList<Note> select(String c, String[] v) {
    ArrayList<Note> notes = new ArrayList<>();
    Cursor cursor;
    if (c != null && v != null) {
      cursor = getWritableDatabase().query("notes", null, c + " = ?", v, null, null, null);
    } else {
      cursor = getWritableDatabase().query("notes", null, null, v, null, null, null);
    }
    if (cursor.getCount() != 0) {
      while (cursor.moveToNext()) {
        Note note = new Note(
          cursor.getString(cursor.getColumnIndex("id")),
          cursor.getString(cursor.getColumnIndex("title")),
          cursor.getString(cursor.getColumnIndex("content")),
          cursor.getString(cursor.getColumnIndex("date"))
        );
        notes.add(note);
      }
    }
    return notes;
  }
}
