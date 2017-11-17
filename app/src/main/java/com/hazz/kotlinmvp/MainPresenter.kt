package com.hazz.kotlinmvp

import com.hazz.kotlinmvp.base.BasePresenter
import com.hazz.kotlinmvp.http.RetrofitManager
import com.hazz.kotlinmvp.scheduler.SchedulerUtils


/**
 * Created by xuhao on 2017/11/8.
 */

class MainPresenter: BasePresenter<MainContract.View>(),MainContract.Presenter{



    override fun getAndroidData(page: Int) {
        mRootView?.showLoading()

        val disposable = RetrofitManager().service.getAndroidData(page)
                .compose(SchedulerUtils.ioToMain())
                .subscribe({
                    result ->
                    if(!result.error){
                        mRootView?.dismissLoading()
                        mRootView?.showAndroidData(result.results)
                    }
                },{
                    t: Throwable? ->
                    mRootView?.apply {
                        dismissLoading()
                        showError(t.toString())

                    }
                })
        addSubscription(disposable)



    }



}
