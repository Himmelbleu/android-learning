package com.example.shopping.utils;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

public class SimpleEvent {

  private final AppCompatActivity app;

  public SimpleEvent(AppCompatActivity app) {
    this.app = app;
  }

  /**
   * 注册点击事件。推荐使用 lambda 表达式简化你的代码。
   *
   * @param onInputEvent 回调函数，在这里实现具体的代码。
   * @param ids          点击的组件 ID
   */
  public void set(OnInputEvent onInputEvent, @IdRes int... ids) {
    for (int id : ids) app.findViewById(id).setOnClickListener(onInputEvent::implement);
  }

}
