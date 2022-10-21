# 学习目的

实现 Activity 之间的跳转，并传递一些信息给另外的页面。

# 实现步骤

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  @Override
  public void onClick(View v) {
    Intent intent = new Intent(this, MessageActivity.class);
    // ......
    startActivity(intent);
  }
}
```

```java
public class MessageActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_message);

    Intent intent = getIntent();
    // ......
  }
}
```

# 报错问题

可能会出现报错问题，这是因为没有通过 Android Studio 右键来辅助创建 Activity 的原因，需要在 manifest 文件中添加如下代码：

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:tools="http://schemas.android.com/tools"
  package="com.example.chap01_activity">

  <application>
    <activity
      android:name=".MessageActivity"
      android:exported="false" />
    <!--......-->
  </application>

</manifest>
```