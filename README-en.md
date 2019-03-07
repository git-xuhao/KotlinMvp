# KotlinMvp

[![](https://jitpack.io/v/git-xuhao/KotlinMvp.svg)](https://jitpack.io/#git-xuhao/KotlinMvp)
[![Build Status](https://travis-ci.org/git-xuhao/KotlinMvp.svg?branch=master)](https://travis-ci.org/git-xuhao/KotlinMvp)
[![CircleCI](https://circleci.com/gh/git-xuhao/KotlinMvp/tree/master.svg?style=svg)](https://circleci.com/gh/git-xuhao/KotlinMvp/tree/master)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/0ee634e0cc3042f8a98e33d6135f39a6)](https://www.codacy.com/app/git-xuhao/KotlinMvp?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=git-xuhao/KotlinMvp&amp;utm_campaign=Badge_Grade)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![](https://img.shields.io/badge/Author-xuhao-blue.svg)](http://xuhaoblog.com)
[![](https://img.shields.io/badge/QQ-504105930-orange.svg)](http://xuhaoblog.com)

![这里写图片描述](https://github-1253441343.cos.ap-chengdu.myqcloud.com/ic_launcher.png)

GitHub：[https://github.com/git-xuhao/KotlinMvp](https://github.com/git-xuhao/KotlinMvp)

（Open source is not easy, if you like, I hope to give a Star or Fork, thank you!）

"KotlinMvp" is a short video app that mimics the previous version of Eye-open Eyepetizer and adds your own ideas, a featured video daily that gives you an eye-opener. This project is written in Kotlin language, combined with MVP + RxJava2 + Retrofit2 + Glide and other architecture design, learning Kotlin use spare time to develop a small project, the code clearly structured detailed annotations, if you have any questions and suggestions please raise the issue or contact[![](https://img.shields.io/badge/Gmail:-igeekho@gmail.com-blue.svg)]()



## Foreword

Kotlin some time ago learned some grammar, and then wrote this project to familiarize yourself with the official language of Android, overall, I feel more cool, compared to Java source code lines have decreased, the number of methods has also been reduced.

The Kotlin team provided a set of tools for Android development that go beyond standard language features:

- [Kotlin Android extension](https://www.kotlincn.net/docs/tutorials/android-plugin.html) Is a compiler extension that lets you get rid of the findViewById () call in your code and replace it with a synthetic compiler-generated property.
- [Anko](http://github.com/kotlin/anko) Is a library of Kotlin-friendly wrappers around the Android API, and a DSL that can replace .xml files with Kotlin code.

## Project screenshot

- screenshot

![](http://oyp2zrwnm.bkt.clouddn.com/pt2017_12_09_10_27_10.jpg)

- gif

   <img src="/screenshot/kotlin-mvp-1.gif" style="width: 30%;">


## Download experience

Click[![](https://img.shields.io/badge/Download-apk-green.svg)](https://fir.im/kotlinmvp) Or scan the two-dimensional code below

**（The following two-dimensional code, the daily limit of 100 times, such as the ceiling, or clone source!✧(≖ ◡ ≖✿)）**

<img src="https://github-1253441343.cos.ap-chengdu.myqcloud.com/WX20190307-154811%402x.png" width = "250" height = "250" alt="图片名称" align=center />



## Technical points
The major third-party open source frameworks are:

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

Module Description:

 - **Daily selection：** The home page is implemented with a drop-down refresh + RecyclerView. Banner displays daily featured videos, listens for RecyclerView's slide events, and implements TitleBar's hidden display. The bottom menu uses gaussian blurring and semitransparenting to refresh the entire APP style.
 - **Find：** Including the attention and classification module, the focus is on the recommended author upload video set, including fashion, sports, creative, advertising, music, travel, life, records, appetizers, games, Meng pets, animation, variety, funny, etc. are free to choose Want to see the type of video.
 - **Popular：** Top Charts include weekly, monthly, top ranked video listings.
 - **Search：** According to the keyword search list you find the video of interest.
 - **Mine：** Personal homepage related introduction.
 - **Watch History：** View previously seen videos, sorted by time.

## Update log

**[Click to view the latest record](https://github.com/git-xuhao/KotlinMvp/releases)**

**v1.1**

 - Remove useless code, add watch record function.

**v1.0**

 - The initial version, the main function has been completed.

## About Me

 - Email: igeekho@gmail.com
 - Home: [https://xuhaoblog.com](https://xuhaoblog.com)
 - CSDN:[http://blog.csdn.net/u011974987](http://blog.csdn.net/u011974987)
 - 简书: [http://www.jianshu.com/u/25bc3e1e7595](http://www.jianshu.com/u/25bc3e1e7595)

## Thanks

- Thanks for all the great open source projects.
- [Eyepetizer](https://github.com/kaikaixue/Eyepetizer) ：The project was initially saw only started to do, learned a lot, writing my own code style.

## Statement
**Project API are from the open-eye video, purely for learning to communicate, shall not be used for commercial purposes!**

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

