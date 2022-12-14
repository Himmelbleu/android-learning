package com.example.cloudmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cloudmusic.beans.User;
import com.example.cloudmusic.databinding.ActivityLoginBinding;

import org.litepal.crud.DataSupport;

public class LoginActivity extends AppCompatActivity {

  private ActivityLoginBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityLoginBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    binding.submit.setOnClickListener(v -> {
      String username = binding.username.getText().toString();
      String password = binding.password.getText().toString();
      User user = DataSupport
        .where("username = ? and password = ?", username, password)
        .findFirst(User.class);
      if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
        Toast.makeText(this, "登陆成功！", Toast.LENGTH_SHORT).show();
        SharedPreferences prefs = getSharedPreferences("userCache", 0);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("username", user.getUsername());
        edit.putString("password", user.getPassword());
        edit.putString("avatar", user.getAvatar());
        edit.putString("signature", user.getSignature());
        edit.putString("level", String.valueOf(user.getLevel()));
        edit.putString("id", String.valueOf(user.getId()));
        edit.putString("sex", user.getSex());
        edit.apply();
        startActivity(new Intent(this, MainActivity.class));
      } else {
        Toast.makeText(this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
      }
    });

    binding.logon.setOnClickListener(v -> {
      Intent intent = new Intent(this, LogonActivity.class);
      startActivity(intent);
    });
  }
}