package com.hazz.kotlinmvp.ui.presenter

import com.hazz.kotlinmvp.ui.contract.HomeContract
import com.hazz.kotlinmvp.base.BasePresenter
import com.hazz.kotlinmvp.bean.HomeBean
import com.hazz.kotlinmvp.http.RetrofitManager
import com.hazz.kotlinmvp.rx.scheduler.SchedulerUtils


/**
 * Created by xuhao on 2017/11/8.
 */

class HomePresenter : BasePresenter<HomeContract.View>(), HomeContract.Presenter {


    var bannerHomeBean:HomeBean?=null


    /**
     * 获取首页精选数据
     */
    override fun requestHomeData(num: Int) {
        mRootView?.showLoading()

        val disposable = RetrofitManager.service.getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain())
                .subscribe({
                    homeBean: HomeBean? ->
                    mRootView?.apply {
                        if (homeBean!=null){
                            dismissLoading()
                            setHomeData(homeBean)
                        }
                    }

                },{
                    t ->
                    mRootView?.apply {
                        dismissLoading()
                        showError(t.toString())
                    }
                })

        addSubscription(disposable)

    }



}
