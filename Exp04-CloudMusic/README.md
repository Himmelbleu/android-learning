# 项目介绍

一个网络音乐播放器，歌曲的来源是网络，没有实现本地歌曲的播放功能。

用到的三方库：

1. Banner
2. Glide
3. LitePal

开发语言：Kotlin + Java

# 项目设计

## 数据库设计

涉及到的实体类有：Song、Songs、User。Songs 与 Song 是多对一的关系。Songs 是歌单，歌单下面有许多的歌曲对象。

## UI 原型设计

![](./docs/首页.png)

首页一共有三个模块，第一个模块是可以轮播图。第二个模块是推荐歌单，点击歌单之后可以进入歌单Activity，展示歌单的基本数据和歌单所属的所有歌曲列表。第三个模块是精选歌曲，是一个 Recl.cverView布局，一列有三个歌曲，一共有三行，点击歌曲直接跳转到播放Activity。

![](./docs/我的.png)

该页面是我的页面，我的页面首先从SharedPrefernces中查询缓存中是否有用户数据，以此来判断是否有用户登录，如果没有用户登录就提示用户登录，点击文字之后跳转到 LoginActivity进行登录操作。

![](./docs/播放页.png)

播放Activity 可以从歌单下的歌曲列表中点击过来，也可以通过首页的精选歌曲点击进入。进入之后，异步从我的腾讯云存储对象中获取网络音乐，并加载到MediaPlaxexr对象，准备完成之后，自动播放音乐，且下面的图片也自动更换。点击切换歌曲之后，从 SharedPrefernces中获取缓存中的歌曲列表，即已经听过的歌曲，从 SQLite 中查找该歌曲所对应的完整数据，获取其中的URL通知Medi.aP1laver对象重新异步加载歌曲，准备播放，并自动更换图标。

## UI 跳转设计

![](./docs/image-1.jpg)

两个Fragment 之间是通过ViewPager2实现的可滑动切换，MaxFindFragment.下的模块点击之后跳转到对应的 Activity。登录的 Activity是通过NaxPersonEragment中进入，且必须当前缓存中没有数据时可以跳转，不登录也是可以正常使用 App 的。

# 问题收集

## 我的博客

1. [LitePal 创建表不生效的问题](https://www.cnblogs.com/Enziandom/#/e/16983830)
2. [Android：Banner 和 Glide 在 Fragment 中实现轮播图](https://www.cnblogs.com/Enziandom/#/e/16975095)
3. [Fragment 和布局文件中的 include 有何区别？](https://www.cnblogs.com/Enziandom/#/e/16972733)

## 其他人的博客

1. [关于 HorizontalScrollView 横向滑动遇到的显示内容不全的问题](https://blog.csdn.net/lezhang123/article/details/55100153)
2. [如何使用 Glide 实现高斯模糊](https://www.jianshu.com/p/83fbc6517b95)
3. [Kotlin语言的map和set集合用法](https://blog.csdn.net/qq_42588016/article/details/123356986)
4. [在Fragment中读取SharedPreference数据](https://blog.csdn.net/xttzka/article/details/123457374)
5. [LitePal数据操作：一对多，多对多](https://www.jianshu.com/p/d16d54321a49?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation)
6. [安卓MediaPlayer切换DataSource - 异步加载 MediaPlayer](https://blog.csdn.net/yutf99/article/details/103200667)
7. [Glide制作圆形图片](https://blog.csdn.net/weixin_43846045/article/details/98888666)
8. [mediaplayer网络播放错误](https://blog.csdn.net/qq_41599205/article/details/103615501)
9. [MediaPlayer播放音频与视频](https://www.runoob.com/w3cnote/android-tutorial-mediaplayer.html)
10. [第59集 视频播放（1）](https://www.bilibili.com/video/BV1HT4y1E7yt/?spm_id_from=333.788.recommend_more_video.-1&vd_source=7427af5060f1aabdb9224fd2278ba015)