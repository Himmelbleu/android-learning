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

  private ActivityPlayerBinding binding;
  private final MediaPlayer player = new MediaPlayer();
  private boolean isDown = false;
  private final ArrayList<String> caching = new ArrayList<>();
  private int index = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityPlayerBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    if (savedInstanceState == null) {
      Song song = (Song) getIntent().getExtras().getSerializable("song");

      renderUI(song);
      renderAudio(song);
      cacheData(song);

      binding.ctrlBtn.setOnClickListener(v -> {
        renderCtlUI();
      });

      binding.lastBtn.setOnClickListener(v -> {
        toggleLastSong();
      });

      binding.nextBtn.setOnClickListener(v -> {
        toggleNextSong();
      });
    }
  }

  private void renderCtlUI() {
    if (isDown) {
      player.pause();
      binding.ctrlBtn.setImageResource(R.drawable.ic_play_circle);
      isDown = false;
    } else {
      player.start();
      binding.ctrlBtn.setImageResource(R.drawable.ic_pause_circle);
      isDown = true;
    }
  }

  private void renderUI(Song song) {
    binding.text.setText(song.getText());
    binding.author.setText(song.getAuthor());
    Glide.with(this).load(song.getSurface())
      .apply(RequestOptions.bitmapTransform(new CircleCrop()))
      .into(binding.surface);
    Glide.with(this).load(song.getSurface())
      .apply(RequestOptions.bitmapTransform(new BlurTransformation(70, 4)))
      .into(binding.bg);
  }

  private void renderAudio(Song song) {
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

  private void cacheData(Song song) {
    SharedPreferences prefs = getSharedPreferences("songCache", 0);
    if (TextUtils.isEmpty(prefs.getString(song.getText(), null)))
      prefs.edit().putString(song.getText(), song.getText()).apply();
    Map<String, ?> maps = prefs.getAll();
    caching.clear();
    for (String key : maps.keySet()) caching.add(String.valueOf(maps.get(key)));
  }

  private void toggleSong() {
    List<Song> songs = DataSupport.where("text = ?", caching.get(index)).find(Song.class);
    player.stop();
    player.seekTo(0);
    renderAudio(songs.get(0));
    renderUI(songs.get(0));
    renderCtlUI();
  }

  private void toggleLastSong() {
    renderCtlUI();
    if (--index < 0) index = caching.size() - 1;
    toggleSong();
  }

  private void toggleNextSong() {
    renderCtlUI();
    if (++index >= caching.size()) index = 0;
    toggleSong();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    player.release();
  }
}