package com.example.cloudmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.cloudmusic.beans.Song;
import com.example.cloudmusic.databinding.ActivityPlayerBinding;

import java.io.IOException;

public class PlayerActivity extends AppCompatActivity {
  private final MediaPlayer player = new MediaPlayer();
  private ActivityPlayerBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityPlayerBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    Song song = (Song) getIntent().getExtras().getSerializable("song");
    binding.text.setText(song.getText());
    binding.author.setText(song.getAuthor());
    RequestOptions options = RequestOptions.bitmapTransform(new CircleCrop());
    Glide.with(this).load(song.getSurface()).apply(options).into(binding.surface);
    initPlayer(song);
  }

  private void initPlayer(Song song) {
    try {
      player.setDataSource(song.getUrl());
      player.prepareAsync();
      player.setOnPreparedListener(mp -> {
        player.start();
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    player.release();
  }
}