package com.hazz.kotlinmvp.base



/**
 * @author Jake.Ho
 * created: 2017/10/25
 * desc: Presenter 基类
 */


interface IPresenter<in V:BaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}
