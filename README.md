# KotlinMvp

[![](https://jitpack.io/v/git-xuhao/KotlinMvp.svg)](https://jitpack.io/#git-xuhao/KotlinMvp)
[![Build Status](https://travis-ci.org/git-xuhao/KotlinMvp.svg?branch=master)](https://travis-ci.org/git-xuhao/KotlinMvp)
[![CircleCI](https://circleci.com/gh/git-xuhao/KotlinMvp/tree/master.svg?style=svg)](https://circleci.com/gh/git-xuhao/KotlinMvp/tree/master)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/0ee634e0cc3042f8a98e33d6135f39a6)](https://www.codacy.com/app/git-xuhao/KotlinMvp?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=git-xuhao/KotlinMvp&amp;utm_campaign=Badge_Grade)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![](https://img.shields.io/badge/Author-xuhao-blue.svg)](http://xuhaoblog.com)
[![](https://img.shields.io/badge/QQ-504105930-orange.svg)](http://xuhaoblog.com)

**[English Document](https://github.com/git-xuhao/KotlinMvp/blob/master/README-en.md)**

![这里写图片描述](https://github-1253441343.cos.ap-chengdu.myqcloud.com/ic_launcher.png)

- **GitHub地址：** [https://github.com/git-xuhao/KotlinMvp](https://github.com/git-xuhao/KotlinMvp)

- **(附上 Java 版本的MVP基础框架)** [https://github.com/git-xuhao/Android-MVP-Architecture](https://github.com/git-xuhao/Android-MVP-Architecture)

**（开源不易，如果喜欢的话希望给个小星星，谢谢~）**

《KotlinMvp》 是仿着“开眼Eyepetizer”之前版本并加上自己的想法，开发的一款的短视频小应用，每日为你推荐精选视频，让你大开眼界。本项目采用 Kotlin 语言编写，结合 MVP+RxJava2+Retrofit2+Glide等的架构设计，学习 Kotlin 利用空余时间开发的一款小项目，代码结构清晰有详细注释，如有任何疑问和建议请提 Issue或联系[![](https://img.shields.io/badge/Gmail:-igeekho@gmail.com-blue.svg)]()



## 前言

前段时间学习了 Kotlin 的一些语法，然后就写了这个项目熟悉一下 Android的官方语言，总体下来，感觉比较爽，相比 Java 而言源代码行数有所减少、方法数也有所减少。

Kotlin 团队为 Android 开发提供了一套超越标准语言功能的工具：

- [Kotlin Android 扩展](https://www.kotlincn.net/docs/tutorials/android-plugin.html)是一个编译器扩展， 可以让你摆脱代码中的 `findViewById()` 调用，并将其替换为合成的编译器生成的属性。
- [Anko](http://github.com/kotlin/anko) 是一个提供围绕 Android API 的 Kotlin 友好的包装器的库 ，以及一个可以用 Kotlin 代码替换布局 .xml 文件的 DSL。

## 项目截图

- 截图

![](http://oyp2zrwnm.bkt.clouddn.com/pt2017_12_09_10_27_10.jpg)

- gif

   <img src="/screenshot/kotlin-mvp-1.gif" style="width: 30%;">


## 下载体验

点击[![](https://img.shields.io/badge/Download-apk-green.svg)](https://fir.im/kotlinmvp) 或者扫描下方二维码

**（下方二维码，每日上限100次，如达到上限，还是 clone 源码吧！✧(≖ ◡ ≖✿)）**

<img src="https://github-1253441343.cos.ap-chengdu.myqcloud.com/WX20190307-154811%402x.png" width = "250" height = "250" alt="图片名称" align=center />



## 技术要点
主要使用的第三方开源框架有：

 - [RxJava](https://github.com/ReactiveX/RxJava)
 - [RxAndroid](https://github.com/ReactiveX/RxAndroid)
 - [Retrofit](https://github.com/square/retrofit)
 - [Glide](https://github.com/bumptech/glide)
 - [Logger](https://github.com/orhanobut/logger)
 - [FlycoTabLayout](https://github.com/H07000223/FlycoTabLayout)
 - [Flexbox-layout](https://github.com/google/flexbox-layout)
 - [RealtimeBlurView](https://github.com/mmin18/RealtimeBlurView)
 - [SmartRefreshLayout](https://github.com/scwang90/SmartRefreshLayout)
 - [BGABanner-Android](https://github.com/bingoogolapple/BGABanner-Android)
 - [GSYVideoPlayer](https://github.com/CarGuo/GSYVideoPlayer)

模块说明：

 - **每日精选：** 首页采用下拉刷新+RecyclerView 实现，Banner展示每日精选推荐的视频，监听 RecyclerView 的滑动事件，实现 TitleBar 的隐藏显示功能，底部菜单采用高斯模糊的半透明效果，使整个 APP 风格更加清爽。
 - **发现：** 包括关注和分类模块，关注是推荐的作者上传的视频集，分类包括时尚、运动、创意、广告、音乐、旅行、生活、记录、开胃、游戏、萌宠、动画、综艺、搞笑等可自由选择想查看的类型视频。
 - **热门：** 热门排行榜包括周排行、月排行、总排行的视频列表。
 - **搜索：** 根据关键字搜索榜你找到感兴趣的视频。
 - **我的：** 个人主页的相关介绍。
 - **观看记录：** 查看之前看过的视频，按时间进行排序。

## 更新日志

**[最新记录请点击查看](https://github.com/git-xuhao/KotlinMvp/releases)**

**v1.3.0**

 - Kotlin版本升级，优化 kotlin 用法；
 - 修复分类详情老接口不能使用问题(原 api 有改动）;
 - 优化代码；

**v1.1**

 - 去除无用代码，添加观看记录功能。

**v1.0**

 - 初始化版本，主要功能已经完成。

## 关于我

 - Email: igeekho@gmail.com
 - Home: [https://xuhaoblog.com](https://xuhaoblog.com)
 - CSDN:[http://blog.csdn.net/u011974987](http://blog.csdn.net/u011974987)
 - 简书: [http://www.jianshu.com/u/25bc3e1e7595](http://www.jianshu.com/u/25bc3e1e7595)

## Thanks

- 感谢所有优秀的开源项目

## 声明
**项目中的 API 均来自开眼视频，纯属学习交流使用，不得用于商业用途！**

## LICENSE

```
Copyright 2017 Xiho

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

