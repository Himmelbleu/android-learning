package com.coolweather.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.coolweather.android.gson.Forecast;
import com.coolweather.android.gson.Weather;
import com.coolweather.android.service.AutoUpdateService;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.Utility;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {

  private ScrollView weatherLayout;
  private TextView titleCity;
  private TextView titleUpdateTime;
  private TextView degreeText;
  private TextView weatherInfoText;
  private LinearLayout forecastLayout;
  private TextView aqiText;
  private TextView pm25Text;
  private TextView comfortText;
  private TextView carWashText;
  private TextView sportText;
  private ImageView bingPicImg;
  public SwipeRefreshLayout swipeRefresh;
  public DrawerLayout drawerLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);

    weatherLayout = findViewById(R.id.weather_layout);
    titleCity = findViewById(R.id.title_city);
    titleUpdateTime = findViewById(R.id.title_update_time);
    degreeText = findViewById(R.id.degree_text);
    weatherInfoText = findViewById(R.id.weather_info_text);
    forecastLayout = findViewById(R.id.forecast_layout);
    aqiText = findViewById(R.id.aqi_text);
    pm25Text = findViewById(R.id.pm25_text);
    comfortText = findViewById(R.id.comfort_text);
    carWashText = findViewById(R.id.car_wash_text);
    sportText = findViewById(R.id.sport_text);
    bingPicImg = findViewById(R.id.bing_pic_img);
    swipeRefresh = findViewById(R.id.swipe_refresh);
    drawerLayout = findViewById(R.id.drawer_layout);
    Button navButton = findViewById(R.id.nav_button);

    swipeRefresh.setColorSchemeResources(R.color.colorPrimary);

    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String weatherString = prefs.getString("weather", null);
    final String weatherId;
    if (weatherString != null) {
      Weather weather = Utility.handleWeatherResponse(weatherString);
      weatherId = weather.basic.weatherId;
      showWeatherInfo(weather);
    } else {
      weatherId = getIntent().getStringExtra("weather_id");
      weatherLayout.setVisibility(View.INVISIBLE);
      requestWeather(weatherId);
    }

    swipeRefresh.setOnRefreshListener(() -> requestWeather(weatherId));
    navButton.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

    String bingPic = prefs.getString("bing_pic", null);
    if (bingPic != null) {
      Glide.with(this).load(bingPic).centerCrop().into(bingPicImg);
    } else {
      loadBingPic();
    }
  }

  private void loadBingPic() {
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
          SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
          editor.putString("bing_pic", bingBg);
          editor.apply();
          runOnUiThread(() -> Glide.with(WeatherActivity.this).load(bingBg).centerCrop().into(bingPicImg));
        } catch (JSONException e) {
          e.printStackTrace();
        }
      }
    });
  }

  public void requestWeather(final String weatherId) {
    String weatherUrl = "http://guolin.tech/api/weather?cityid=" + weatherId + "&key=bc0418b2d4918819d3974ac1285d9";
    HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
        runOnUiThread(() -> {
          Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
          swipeRefresh.setRefreshing(false);
        });
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        final String responseText = response.body().string();
        final Weather weather = Utility.handleWeatherResponse(responseText);
        runOnUiThread(() -> {
          if (weather != null && "ok".equals(weather.status)) {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
            editor.putString("weather", responseText);
            editor.apply();
            showWeatherInfo(weather);
          } else {
            Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
          }
          swipeRefresh.setRefreshing(false);
        });
      }
    });

    loadBingPic();
  }

  @SuppressLint("SetTextI18n")
  private void showWeatherInfo(Weather weather) {
    if (weather != null && "ok".equals(weather.status)) {
      String cityName = weather.basic.cityName;
      String updateTime = weather.basic.update.updateTime.split(" ")[1];
      String degree = weather.now.temperature + "°C";
      String weatherInfo = weather.now.more.info;
      titleCity.setText(cityName);
      titleUpdateTime.setText(updateTime);
      degreeText.setText(degree);
      weatherInfoText.setText(weatherInfo);
      forecastLayout.removeAllViews();
      for (Forecast forecast : weather.forecastList) {
        View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
        TextView dateText = view.findViewById(R.id.date_text);
        TextView infoText = view.findViewById(R.id.info_text);
        TextView maxText = view.findViewById(R.id.max_text);
        TextView minText = view.findViewById(R.id.min_text);
        dateText.setText(forecast.date);
        infoText.setText(forecast.more.info);
        maxText.setText(forecast.temperature.max + "°C");
        minText.setText(forecast.temperature.min + "°C");
        forecastLayout.addView(view);
      }
      if (weather.aqi != null) {
        aqiText.setText(weather.aqi.city.aqi);
        pm25Text.setText(weather.aqi.city.pm25);
      }
      String comfort = "舒适度：" + weather.suggestion.comfort.info;
      String carWash = "洗车指数：" + weather.suggestion.carWash.info;
      String sport = "运动建议：" + weather.suggestion.sport.info;
      comfortText.setText(comfort);
      carWashText.setText(carWash);
      sportText.setText(sport);
      weatherLayout.setVisibility(View.VISIBLE);
      Intent intent = new Intent(this, AutoUpdateService.class);
      startService(intent);
    } else {
      Toast.makeText(this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
    }
  }
}