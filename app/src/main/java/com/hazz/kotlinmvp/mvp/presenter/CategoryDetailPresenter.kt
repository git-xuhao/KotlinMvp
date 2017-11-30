package com.hazz.kotlinmvp.mvp.presenter

import com.hazz.kotlinmvp.base.BasePresenter
import com.hazz.kotlinmvp.mvp.contract.CategoryDetailContract
import com.hazz.kotlinmvp.mvp.model.CategoryDetailModel

/**
 * Created by xuhao on 2017/11/30.
 * desc:
 */
class CategoryDetailPresenter:BasePresenter<CategoryDetailContract.View>(),CategoryDetailContract.Presenter{

   private val categoryDetailModel by lazy {
       CategoryDetailModel()
   }

    private var nextPageUrl = ""

    /**
     * 获取分类详情的列表信息
     */
    override fun getCategoryDetailList(id: Long) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable= categoryDetailModel.getCategoryDetailList(id)
                .subscribe({
                    issue ->
                    mRootView?.apply {
                        dismissLoading()
                        nextPageUrl = issue.nextPageUrl
                        setCateDetailList(issue.itemList)
                    }
                },{
                    throwable ->
                    mRootView?.apply {
                        dismissLoading()
                        showError(throwable.toString())
                    }
                })

        addSubscription(disposable)
    }

    /**
     * 加载更多数据
     */
    override fun loadMoreData() {
        mRootView?.showLoading()
        val disposable = categoryDetailModel.loadMoreData(nextPageUrl)
                .subscribe({
                    issue ->
                    mRootView?.apply {
                        dismissLoading()
                        nextPageUrl = issue.nextPageUrl
                        setCateDetailList(issue.itemList)
                    }
                },{
                    throwable->
                    mRootView?.apply {
                        dismissLoading()
                        showError(throwable.toString())
                    }
                })

        addSubscription(disposable)
    }
}