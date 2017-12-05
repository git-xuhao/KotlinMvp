package com.hazz.kotlinmvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.base.BaseFragmentAdapter
import com.hazz.kotlinmvp.mvp.contract.HotTabContract
import com.hazz.kotlinmvp.mvp.model.bean.TabInfoBean
import com.hazz.kotlinmvp.mvp.presenter.HotTabPresenter
import kotlinx.android.synthetic.main.fragment_hot.*

/**
 * Created by xuhao on 2017/11/9.
 * 热门
 */
class HotFragment : BaseFragment(), HotTabContract.View {

    private val mPresenter by lazy { HotTabPresenter() }

    private var mTitle: String? = null

    /**
     * 存放 tab 标题
     */
    private val mTabTitleList = ArrayList<String>()

    private val mFragmentList = ArrayList<Fragment>()

    companion object {
        fun getInstance(title: String): HotFragment {
            val fragment = HotFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    init {
        mPresenter.attachView(this)
    }


    override fun getLayoutId(): Int = R.layout.fragment_hot


    override fun lazyLoad() {
        mPresenter.getTabInfo()
    }

    override fun initView() {

    }


    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    /**
     * 设置 TabInfo
     */
    override fun setTabInfo(tabInfoBean: TabInfoBean) {

        tabInfoBean.tabInfo.tabList.mapTo(mTabTitleList) { it.name }
        tabInfoBean.tabInfo.tabList.mapTo(mFragmentList) { RankFragment.getInstance(it.apiUrl) }

        mViewPager.adapter = BaseFragmentAdapter(fragmentManager,mFragmentList,mTabTitleList)
        mTabLayout.setupWithViewPager(mViewPager)

    }

    override fun showError(errorMsg: String) {

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}