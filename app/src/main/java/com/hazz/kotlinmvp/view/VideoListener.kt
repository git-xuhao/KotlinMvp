package com.hazz.kotlinmvp.view

import com.shuyu.gsyvideoplayer.listener.StandardVideoAllCallBack

/**
 * Created by xuhao on 2017/11/27.
 * desc: VideoAllCallBack 回调
 */
interface VideoListener : StandardVideoAllCallBack {

    //加载成功，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onPrepared(url: String, vararg objects: Any) {

    }

    //点击了开始按键播放，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickStartIcon(url: String, vararg objects: Any) {

    }

    //点击了错误状态下的开始按键，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickStartError(url: String, vararg objects: Any) {

    }

    //点击了播放状态下的开始按键--->停止，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickStop(url: String, vararg objects: Any) {

    }

    //点击了全屏播放状态下的开始按键--->停止，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickStopFullscreen(url: String, vararg objects: Any) {

    }

    //点击了暂停状态下的开始按键--->播放，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickResume(url: String, vararg objects: Any) {

    }

    //点击了全屏暂停状态下的开始按键--->播放，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickResumeFullscreen(url: String, vararg objects: Any) {

    }

    //点击了空白弹出seekbar，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickSeekbar(url: String, vararg objects: Any) {

    }

    //点击了全屏的seekbar，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickSeekbarFullscreen(url: String, vararg objects: Any) {

    }

    //播放完了，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onAutoComplete(url: String, vararg objects: Any) {

    }

    //进去全屏，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onEnterFullscreen(url: String, vararg objects: Any) {

    }

    //退出全屏，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onQuitFullscreen(url: String, vararg objects: Any) {

    }

    //进入小窗口，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onQuitSmallWidget(url: String, vararg objects: Any) {

    }

    //退出小窗口，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onEnterSmallWidget(url: String, vararg objects: Any) {

    }

    //触摸调整声音，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onTouchScreenSeekVolume(url: String, vararg objects: Any) {

    }

    //触摸调整进度，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onTouchScreenSeekPosition(url: String, vararg objects: Any) {

    }

    //触摸调整亮度，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onTouchScreenSeekLight(url: String, vararg objects: Any) {

    }

    //播放错误，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onPlayError(url: String, vararg objects: Any) {

    }

    //点击了空白区域开始播放，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickStartThumb(url: String, vararg objects: Any) {

    }

    //点击了播放中的空白区域，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickBlank(url: String, vararg objects: Any) {

    }

    //点击了全屏播放中的空白区域，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    override fun onClickBlankFullscreen(url: String, vararg objects: Any) {

    }
}