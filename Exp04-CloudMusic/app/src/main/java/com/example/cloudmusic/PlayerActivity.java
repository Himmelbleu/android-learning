package com.example.cloudmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.cloudmusic.beans.Song;
import com.example.cloudmusic.databinding.ActivityPlayerBinding;

import java.io.IOException;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayerActivity extends AppCompatActivity {
  private final MediaPlayer player = new MediaPlayer();
  private ActivityPlayerBinding binding;

  private boolean isDown = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityPlayerBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    Song song = (Song) getIntent().getExtras().getSerializable("song");
    binding.text.setText(song.getText());
    binding.author.setText(song.getAuthor());
    Glide.with(this).load(song.getSurface())
      .apply(RequestOptions.bitmapTransform(new CircleCrop()))
      .into(binding.surface);
    Glide.with(this).load(song.getSurface())
      .apply(RequestOptions.bitmapTransform(new BlurTransformation(70, 4)))
      .into(binding.bg);

    initPlayer(song);

    binding.ctrlBtn.setOnClickListener(v -> {
      if (isDown) {
        player.pause();
        binding.ctrlBtn.setImageResource(R.drawable.ic_play_circle);
        isDown = false;
      } else {
        player.start();
        binding.ctrlBtn.setImageResource(R.drawable.ic_pause_circle);
        isDown = true;
      }
    });
  }

  private void initPlayer(Song song) {
    try {
      player.setDataSource(song.getUrl());
      player.prepareAsync();
      player.setOnPreparedListener(mp -> {
        player.start();
        binding.ctrlBtn.setImageResource(R.drawable.ic_pause_circle);
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