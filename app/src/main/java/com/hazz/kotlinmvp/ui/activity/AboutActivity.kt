package com.hazz.kotlinmvp.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import com.hazz.kotlinmvp.MyApplication
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseActivity
import com.hazz.kotlinmvp.utils.AppUtils
import com.hazz.kotlinmvp.utils.StatusBarUtil
import kotlinx.android.synthetic.main.activity_about.*

/**
 * Created by xuhao on 2017/12/6.
 * desc: 关于
 */
class AboutActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_about

    override fun initData() {
    }

    @SuppressLint("SetTextI18n")
    override fun initView() {
        StatusBarUtil.darkMode(this)
        StatusBarUtil.setPaddingSmart(this, toolbar)

        tv_version_name.text ="v${AppUtils.getVerName(MyApplication.context)}"
        //返回
        toolbar.setNavigationOnClickListener { finish() }
        //访问 GitHub
        relayout_gitHub.setOnClickListener {
            val uri = Uri.parse("https://github.com/git-xuhao/KotlinMvp")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    override fun start() {

    }
}