package com.hazz.kotlinmvp.bean

import com.flyco.tablayout.listener.CustomTabEntity



/**
 * Created by xuhao on 2017/11/16.
 * desc:
 */
class TabEntity(var title: String, private var selectedIcon: Int, private var unSelectedIcon: Int) : CustomTabEntity {

    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }
}