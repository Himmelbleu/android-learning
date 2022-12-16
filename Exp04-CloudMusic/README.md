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
