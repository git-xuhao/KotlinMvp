package com.hazz.kotlinmvp

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by xuhao on 2017/11/14.
 */

fun Fragment.showToast(content: String): Toast {
    val toast = Toast.makeText(this.activity, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

fun Context.showToast(content: String): Toast {
    val toast = Toast.makeText(this, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

