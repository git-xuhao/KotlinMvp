package com.hazz.kotlinmvp.mvp.presenter

import com.hazz.kotlinmvp.base.BasePresenter
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean
import com.hazz.kotlinmvp.mvp.contract.HomeContract
import com.hazz.kotlinmvp.mvp.model.HomeModel

/**
 * Created by xuhao on 2017/11/8.
 * 首页精选的 Presenter
 */

class HomePresenter : BasePresenter<HomeContract.View>(), HomeContract.Presenter {


    private var bannerHomeBean: HomeBean? = null

    private val homeModel: HomeModel by lazy {

        HomeModel()
    }


    /**
     * 获取首页精选数据 banner 加 一页数据
     */
    override fun requestHomeData(num: Int) {
        mRootView?.showLoading()
        val disposable = homeModel.requestHomeData(num)
                .flatMap({ homeBean ->

                    //过滤掉 Banner2(包含广告,等无用的 Type), 具体查看接口分析
                    val bannerItemList = homeBean.issueList[0].itemList

                    bannerItemList.filter { item ->
                        item.type=="banner2"|| item.type=="horizontalScrollCard"
                    }.forEach{ item ->
                        //移除 item
                        bannerItemList.remove(item)
                    }

                    bannerHomeBean = homeBean //记录第一页是当做 banner 数据


                    //根据 nextPageUrl 请求下一页数据
                    homeModel.loadMoreData(homeBean.nextPageUrl)
                })
                .subscribe({ homeBean->
                    mRootView?.apply {
                        dismissLoading()

                        //过滤掉 Banner2(包含广告,等无用的 Type), 具体查看接口分析
                        val newBannerItemList = homeBean.issueList[0].itemList

                        newBannerItemList.filter { item ->
                            item.type=="banner2"||item.type=="horizontalScrollCard"
                        }.forEach{ item ->
                            //移除 item
                            newBannerItemList.remove(item)
                        }
                        // 记录Banner 长度
                        bannerHomeBean!!.issueList[0].count = bannerHomeBean!!.issueList[0].itemList.size

                        //赋值过滤后的数据 + banner 数据
                        bannerHomeBean?.issueList!![0].itemList.addAll(newBannerItemList)

                        setHomeData(bannerHomeBean!!)

                    }

                }, { t ->
                    mRootView?.apply {
                        dismissLoading()
                        showError(t.toString())
                    }
                })

        addSubscription(disposable)

    }


}