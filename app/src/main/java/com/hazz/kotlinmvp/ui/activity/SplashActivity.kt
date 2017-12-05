package com.hazz.kotlinmvp.ui.activity

import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseActivity
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_splash.*
import android.content.Intent




/**
 * Created by xuhao on 2017/12/5.
 * desc:
 */
class SplashActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_splash

    override fun initData() {

    }

    override fun initView() {
        //渐变展示启动屏
        val aa = AlphaAnimation(0.3f, 1.0f)
        aa.duration = 2000
        layout_splash.startAnimation(aa)
        aa.setAnimationListener(object : AnimationListener {
            override fun onAnimationEnd(arg0: Animation) {
                redirectTo()
            }

            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationStart(animation: Animation) {}

        })


    }

    override fun start() {
    }


    private fun redirectTo() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}