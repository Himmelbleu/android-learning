package com.example.cloudmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.cloudmusic.beans.User;
import com.example.cloudmusic.databinding.ActivityLogonBinding;

import org.litepal.crud.DataSupport;

public class LogonActivity extends AppCompatActivity {

  private ActivityLogonBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityLogonBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    binding.submit.setOnClickListener(v -> {
      String username = binding.username.getText().toString();
      User first = DataSupport.where("username = ?", username).findFirst(User.class);
      if (first != null && !TextUtils.isEmpty(first.getUsername())) {
        Toast.makeText(this, "账户已存在！", Toast.LENGTH_SHORT).show();
      } else {
        User user = new User();
        user.setLevel(1);
        user.setUsername(username);
        user.setPassword(binding.password.getText().toString());
        user.setSex("未知");
        user.setSignature("这个人很懒，什么也没有留下");
        user.setAvatar("https://img1.baidu.com/it/u=4035421571,4160111639&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
        user.save();
        Toast.makeText(this, "注册成功！跳转到登录页", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
      }
    });

    binding.login.setOnClickListener(v -> {
      Intent intent = new Intent(this, LoginActivity.class);
      startActivity(intent);
    });
  }
}