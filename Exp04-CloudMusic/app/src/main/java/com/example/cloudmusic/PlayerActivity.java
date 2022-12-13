package com.example.cloudmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.cloudmusic.beans.Song;
import com.example.cloudmusic.databinding.ActivityPlayerBinding;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayerActivity extends AppCompatActivity {

  private final MediaPlayer player = new MediaPlayer();
  private ActivityPlayerBinding binding;
  private boolean isDown = false;
  private final ArrayList<String> cacheSongs = new ArrayList<>();
  private int songIndex = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityPlayerBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    Song song = (Song) getIntent().getExtras().getSerializable("song");

    loadUI(song);
    loadPlayer(song);
    cacheSongs(song);

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

    binding.lastBtn.setOnClickListener(v -> {
      switchLastSong();
    });

    binding.nextBtn.setOnClickListener(v -> {
      switchNextSong();
    });
  }

  private void loadUI(Song song) {
    binding.text.setText(song.getText());
    binding.author.setText(song.getAuthor());
    Glide.with(this).load(song.getSurface())
      .apply(RequestOptions.bitmapTransform(new CircleCrop()))
      .into(binding.surface);
    Glide.with(this).load(song.getSurface())
      .apply(RequestOptions.bitmapTransform(new BlurTransformation(70, 4)))
      .into(binding.bg);
  }

  private void loadPlayer(Song song) {
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

  private void cacheSongs(Song song) {
    SharedPreferences prefs = getSharedPreferences("songCache", 0);
    String text = prefs.getString(song.getText(), null);
    if (TextUtils.isEmpty(text)) prefs.edit().putString(song.getText(), song.getText()).apply();
    Map<String, ?> maps = prefs.getAll();
    cacheSongs.clear();
    for (String key : maps.keySet()) {
      cacheSongs.add(String.valueOf(maps.get(key)));
    }
  }

  private void switchSong() {
    List<Song> songs = DataSupport.where("text = ?", cacheSongs.get(songIndex)).find(Song.class);
    player.stop();
    player.seekTo(0);
    loadPlayer(songs.get(0));
    loadUI(songs.get(0));
  }

  private void switchLastSong() {
    songIndex--;
    if (songIndex < 0) {
      songIndex = cacheSongs.size() - 1;
    }
    switchSong();
  }

  private void switchNextSong() {
    songIndex++;
    if (songIndex >= cacheSongs.size()) {
      songIndex = 0;
    }
    switchSong();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    player.release();
  }
}