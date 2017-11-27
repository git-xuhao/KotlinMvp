package com.hazz.kotlinmvp.ui.activity

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import com.hazz.kotlinmvp.Constants
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseActivity
import com.hazz.kotlinmvp.mvp.contract.VideoDetailContract
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean
import com.hazz.kotlinmvp.mvp.presenter.VideoDetailPresenter
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer
import kotlinx.android.synthetic.main.activity_video_detail.*

/**
 * Created by xuhao on 2017/11/25.
 * desc: 视频详情
 */
class VideoDetailActivity : BaseActivity(), VideoDetailContract.View {

    /**
     * 第一次调用的时候初始化
     */
    private val mPresenter by lazy { VideoDetailPresenter() }

    /**
     * Item 详细数据
     */
    private var itemData: HomeBean.Issue.Item? = null


    override fun layoutId(): Int = R.layout.activity_video_detail

    /**
     * 初始化 View
     */
    override fun initView() {
        //是否旋转
        mVideoView.isRotateViewAuto = false
        mVideoView.fullscreenButton.setOnClickListener {
            if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }
            //将 VideoView 设置到全屏
            mVideoView.startWindowFullscreen(this, true, true)
        }

        mPresenter.attachView(this)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        itemData = intent.getSerializableExtra(Constants.BUNDLE_VIDEO_DATA) as HomeBean.Issue.Item

        mPresenter.loadVideoInfo(itemData!!)
    }


    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    /**
     * 设置播放视频 URL
     */
    override fun setVideo(url: String) {
         mVideoView.setUp(url,false,"")
         mVideoView.startPlayLogic()
    }

    /**
     * 设置视频信息
     */
    override fun setVideoInfo(itemInfo: HomeBean.Issue.Item) {

    }

    /**
     * 设置背景颜色
     */
    override fun setBackground(url: String) {

    }

    /**
     * 设置错误信息
     */
    override fun setErrorMsg(errorMsg: String) {

    }


    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        mVideoView.fullWindowPlayer.fullscreenButton.setOnClickListener {
            GSYVideoPlayer.backFromWindowFull(this)
            if(this.resources.configuration.orientation!=Configuration.ORIENTATION_PORTRAIT){
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        }
    }


    /**
     * 监听返回键
     */
    override fun onBackPressed() {
        super.onBackPressed()
        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            if (this.resources.configuration.orientation != Configuration.ORIENTATION_PORTRAIT) {
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
            return
        }
    }

    override fun onResume() {
        super.onResume()
        GSYVideoManager.onResume()
    }

    override fun onPause() {
        super.onPause()
        GSYVideoManager.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        GSYVideoPlayer.releaseAllVideos()
    }


}