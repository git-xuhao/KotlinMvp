package com.hazz.kotlinmvp.mvp.contract

import com.hazz.kotlinmvp.base.BaseView
import com.hazz.kotlinmvp.base.IPresenter
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean

/**
 * Created by xuhao on 2017/11/8.
 * 契约类
 */

interface HomeContract {

    interface View : BaseView {

        fun setHomeData(homeBean: HomeBean)

        fun showError(msg: String)


    }

    interface Presenter : IPresenter<View> {

        /**
         * 获取首页精选数据
         */
        fun requestHomeData(num: Int)


    }


}