package com.coolweather.android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;

import com.coolweather.android.gson.Weather;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.Utility;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AutoUpdateService extends Service {

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    updateWeather();
    upadteBingPic();
    AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
    int anHour = 8 * 60 * 60 * 1000; // 8 小时的毫秒数
    long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
    Intent i = new Intent(this, AutoUpdateService.class);
    PendingIntent pi = PendingIntent.getService(this, 0, i, 0);
    manager.cancel(pi);
    manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  private void updateWeather() {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String weatherString = prefs.getString("weather", null);
    if (weatherString != null) {
      Weather weather = Utility.handleWeatherResponse(weatherString);
      String weatherId = weather.basic.weatherId;
      String weatherUrl = "http://guolin.tech/api/weather?cityid=" + weatherId + "&key=bc0418b2d4918819d3974ac1285d9";
      HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
          e.printStackTrace();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
          String resText = response.body().string();
          Weather wt = Utility.handleWeatherResponse(resText);
          if (wt != null && "ok".equals(wt.status)) {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
            editor.putString("weather", resText);
            editor.apply();
          }
        }
      });
    }
  }

  private void upadteBingPic() {
    HttpUtil.sendOkHttpRequest("https://api.no0a.cn/api/bing/0", new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        final String bingBg;
        try {
          bingBg = new JSONObject(response.body().string()).getJSONObject("bing").getString("url");
          SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
          editor.putString("bing_pic", bingBg);
          editor.apply();
        } catch (JSONException e) {
          e.printStackTrace();
        }
      }
    });
  }
}