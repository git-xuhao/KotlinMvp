package com.hazz.kotlinmvp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author Jake.Ho
 * created: 2017/10/25
 * desc:
 */
 abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())


    }


    protected abstract fun layoutId(): Int




}


