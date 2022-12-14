package com.example.cloudmusic.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.cloudmusic.PlayerActivity;
import com.example.cloudmusic.R;
import com.example.cloudmusic.beans.Song;

import java.util.List;

public class SongsActivityAdapter extends RecyclerView.Adapter<SongsActivityAdapter.SongsActivityViewHolder> {
  private final List<Song> list;
  private final Context context;

  public SongsActivityAdapter(List<Song> list, Context context) {
    this.list = list;
    this.context = context;
  }

  @NonNull
  @Override
  public SongsActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new SongsActivityViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cust_songs, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull SongsActivityViewHolder holder, int position) {
    Glide.with(context).load(list.get(position).getSurface())
      .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
      .into(holder.surfaceView);
    holder.textView.setText(list.get(position).getText());
    holder.authorTextView.setText(list.get(position).getAuthor());

    holder.itemView.setOnClickListener(v -> {
      Intent intent = new Intent(context, PlayerActivity.class);
      Bundle bundle = new Bundle();
      bundle.putSerializable("song", list.get(position));
      intent.putExtras(bundle);
      context.startActivity(intent);
    });
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  static class SongsActivityViewHolder extends RecyclerView.ViewHolder {
    private final ImageView surfaceView;
    private final TextView textView;
    private final TextView authorTextView;

    public SongsActivityViewHolder(@NonNull View itemView) {
      super(itemView);
      this.surfaceView = itemView.findViewById(R.id.surface);
      this.textView = itemView.findViewById(R.id.text);
      this.authorTextView = itemView.findViewById(R.id.author);
    }
  }

}
