# 项目说明

这是用于保存本人学习 Android 开发的代码仓库。

Android 开发有原生开发和非原生开发，非原生开发有一个特点就是一套代码多个平台运行，而原生开发只能在本平台上运行。 从效率上来看，招收一个 Web 前端程序员，通过非原生框架既可以开发 Web
App，又可以开发其他平台 App，可以节省人工费（泪）。 但是原生开发的应用速度肯定比非原生开发的速度快，非原生开发有基于 WebView 的，也就是完全的 Web
知识做界面（UI）。而原生开发就是通过 xml 来构建 UI，Java 写逻辑代码。

非原生开发框架：

Uni-App、React Native 等基于 WebView 的非原生 Android 开发框架。原生应用、Web 应用和混合应用的概念 Flutter
与用于构建移动应用程序的其他大多数框架不同，因为 Flutter 既不使用 WebView，也不使用操作系统的原生控件。 相反，Flutter 使用自己的高性能渲染引擎来绘制
Widget（组件）。Flutter 实战·第二版 虽然有经济效益、效率更高的非原生开发框架，但是，Android 原生开发的学习依旧是有意义的。鸿蒙应用开发跟 Android 很类似，甚至有些
API 都需要通过 Android 来调用。所以，学习一个通 N 个。

# Exp01-Survey

问卷调查应用，使用了 ViewModel 和 Adapter、ListView 组件等。入门安卓开发的第一步。

# Exp02-Shopping

模仿小米商城的 App。Fragment 对 Activity 进行拆分重组、重用，Intent 显示跳转页面，传递复杂数据 Bundle 对象。

ScrollView、RecycleView、RelatedLayout 等布局和视图的使用方法。Fragment 跳转到 Activity 的技巧。

使用了其他库：Glide、Banner。Glide 用于加载网络图片、Banner 是轮播图的第三方工具库。这两个工具库都来自于 Github 平台。

通过本次实验，进一步熟悉了安卓开发的流程，但目前 App 用的还是死数据，之后结合 litepal 等内置应用的数据库做一个活数据。