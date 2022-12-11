package com.example.notepad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

  private ArrayList<Note> noteList;

  public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView date;

    public TextView getTitle() {
      return title;
    }

    public void setTitle(TextView title) {
      this.title = title;
    }

    public TextView getDate() {
      return date;
    }

    public void setDate(TextView date) {
      this.date = date;
    }

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      title = (TextView) itemView.findViewById(R.id.note_item_title);
      date = itemView.findViewById(R.id.note_item_date);
    }
  }

  public NotesAdapter(ArrayList<Note> noteList) {
    this.noteList = noteList;
  }

  public ArrayList<Note> getNoteList() {
    return noteList;
  }

  public void setNoteList(ArrayList<Note> noteList) {
    this.noteList = noteList;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.getTitle().setText(noteList.get(position).getTitle());
    holder.getDate().setText(noteList.get(position).getContent());
  }

  @Override
  public int getItemCount() {
    return noteList.size();
  }

}
