package com.example.cloudmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.cloudmusic.adapters.SongsActivityAdapter;
import com.example.cloudmusic.beans.Song;
import com.example.cloudmusic.beans.Songs;
import com.example.cloudmusic.databinding.ActivitySongsBinding;

import org.litepal.crud.DataSupport;

public class SongsActivity extends AppCompatActivity {
  private ActivitySongsBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivitySongsBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    if (savedInstanceState == null) {
      Songs res = (Songs) getIntent().getExtras().getSerializable("songs");

      binding.songsText.setText(res.getText());
      Glide.with(this).load(res.getSurface())
        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
        .into(binding.songsSurface);

      binding.songList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
      binding.songList.setAdapter(
        new SongsActivityAdapter(
          DataSupport.where("songs_id = ?", String.valueOf(res.getId())).find(Song.class)
          , this
        )
      );
    }
  }
}