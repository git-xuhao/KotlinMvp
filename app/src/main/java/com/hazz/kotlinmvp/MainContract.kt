package com.hazz.kotlinmvp

import com.hazz.kotlinmvp.base.IPresenter
import com.hazz.kotlinmvp.base.BaseView
import com.hazz.kotlinmvp.bean.FuckGoods

/**
 * Created by xuhao on 2017/11/8.
 * 契约类
 */

interface MainContract {

    interface View : BaseView {


        fun showAndroidData(fuckGoods: List<FuckGoods>)

        fun showError(msg: String)


    }

    interface Presenter : IPresenter<View> {

        fun getAndroidData(page: Int)


    }


}
