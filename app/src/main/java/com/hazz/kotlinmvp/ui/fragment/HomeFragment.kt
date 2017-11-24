package com.hazz.kotlinmvp.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean
import com.hazz.kotlinmvp.mvp.contract.HomeContract
import com.hazz.kotlinmvp.mvp.presenter.HomePresenter
import com.hazz.kotlinmvp.showToast
import com.hazz.kotlinmvp.ui.adapter.HomeAdapter
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by xuhao on 2017/11/8.
 * 首页精选
 */

class HomeFragment : BaseFragment(), HomeContract.View{


    private var mPresenter: HomeContract.Presenter = HomePresenter()

    private var mTitle: String? = null

    private var num:Int=1

    private var mHomeAdapter:HomeAdapter?=null

    companion object {
        fun getInstance(title : String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }


    override fun getLayoutId(): Int = R.layout.fragment_home


    /**
     * 初始化 View
     */
    override fun initView() {
        mRefreshLayout.setOnRefreshListener { mPresenter.requestHomeData(num) }

    }

    override fun lazyLoad() {
        mPresenter.attachView(this)

        mPresenter.requestHomeData(num)

    }


    /**
     * 显示 Loading
     */
    override fun showLoading() {

    }

    /**
     * 隐藏 Loading
     */
    override fun dismissLoading() {
        mRefreshLayout.finishRefresh()
    }

    /**
     * 设置首页数据
     */
    override fun setHomeData(homeBean: HomeBean) {
        Logger.d(homeBean)
        // Adapter
        mHomeAdapter = HomeAdapter(activity,homeBean.issueList[0].itemList)
        //设置 banner 大小
        mHomeAdapter?.setBannerSize(homeBean.issueList[0].count)

        showToast(homeBean.issueList[0].count.toString())
        mRecyclerView.adapter = mHomeAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(activity)

    }


    override fun showError(msg: String) {

    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }






}
