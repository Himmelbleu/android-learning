# 填充数组

```kotlin
class MainActivity : AppCompatActivity(R.layout.activity_main) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (savedInstanceState == null) {
      val navBars = listOf<TextView>(
        findViewById(R.id.nav_index),
        findViewById(R.id.nav_dynamic),
        findViewById(R.id.nav_person)
      )
      val fragments = listOf(IndexFragment(), DynamicFragment(), PersonFragment())
    }
  }

}
```

# 创建 ViewPager2Adapter

```kotlin
class ViewPage2Adapter(fragmentActivity: FragmentActivity, fragments: List<Fragment>) :
  FragmentStateAdapter(fragmentActivity) {

  private var fragments: List<Fragment>

  init {
    this.fragments = fragments
  }

  override fun getItemCount(): Int {
    return fragments.size
  }

  override fun createFragment(position: Int): Fragment {
    return fragments[position]
  }

}
```

# MainActivity

```kotlin
class MainActivity : AppCompatActivity(R.layout.activity_main) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (savedInstanceState == null) {
      // ... 上述步骤
      val pager = findViewById<ViewPager2>(R.id.view_pager2)
      pager.adapter = ViewPage2Adapter(this, fragments)
    }
  }

}
```

# 切换 Fragment 时修改 TabBar 背景颜色

```kotlin
class MainActivity : AppCompatActivity(R.layout.activity_main) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (savedInstanceState == null) {
      // ... 上述步骤

      var lastPosition = 0
      pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(currPosition: Int) {
          navBars[lastPosition].setBackgroundResource(R.color.white)
          navBars[currPosition].setBackgroundResource(R.color.nav_selected)
          lastPosition = currPosition
        }
      })

      navBars[0].setOnClickListener {
        Log.d("Test", pager.currentItem.toString())
        pager.currentItem = 0
      }

      navBars[1].setOnClickListener {
        pager.currentItem = 1
      }

      navBars[2].setOnClickListener {
        pager.currentItem = 2
      }
    }
  }

}
```