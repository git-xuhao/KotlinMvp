package com.hazz.kotlinmvp.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.orhanobut.logger.Logger

import java.lang.reflect.Field

/**
 * Created by xuhao on 2017/12/13.
 * desc:
 */

object CleanLeakUtils {

    fun fixInputMethodManagerLeak(destContext: Context?) {
        if (destContext == null) {
            return
        }
        val inputMethodManager = destContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        val viewArray = arrayOf("mCurRootView", "mServedView", "mNextServedView")
        var filed: Field
        var filedObject: Any?

        for (view in viewArray) {
            try {
                filed = inputMethodManager.javaClass.getDeclaredField(view)
                if (!filed.isAccessible) {
                    filed.isAccessible = true
                }
                filedObject = filed.get(inputMethodManager)
                if (filedObject != null && filedObject is View) {
                    val fileView = filedObject as View?
                    if (fileView!!.context === destContext) { // 被InputMethodManager持有引用的context是想要目标销毁的
                        filed.set(inputMethodManager, null) // 置空，破坏掉path to gc节点
                    } else {
                        break// 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
                    }
                }
            } catch (t: Throwable) {
                t.printStackTrace()
            }

        }
    }
}
