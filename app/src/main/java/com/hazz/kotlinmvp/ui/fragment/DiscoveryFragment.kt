package com.hazz.kotlinmvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.base.BaseFragmentAdapter
import com.hazz.kotlinmvp.utils.StatusBarUtil
import com.hazz.kotlinmvp.view.TabLayoutHelper
import kotlinx.android.synthetic.main.fragment_hot.*

/**
 * Created by xuhao on 2017/12/7.
 * desc: 发现(和热门首页同样的布局）
 */
class DiscoveryFragment : BaseFragment() {

    private val tabList = ArrayList<String>()

    private val fragments = ArrayList<Fragment>()

    private var mTitle: String? = null

    companion object {
        fun getInstance(title: String): DiscoveryFragment {
            val fragment = DiscoveryFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_hot

    override fun initView() {

        //状态栏透明和间距处理
        StatusBarUtil.darkMode(activity)
        StatusBarUtil.setPaddingSmart(activity, toolbar)

        tv_header_title.text = mTitle

        tabList.add("关注")
        tabList.add("分类")
        fragments.add(FollowFragment.getInstance("关注"))
        fragments.add(CategoryFragment.getInstance("分类"))

        /**
         * getSupportFragmentManager() 替换为getChildFragmentManager()
         */
        mViewPager.adapter = BaseFragmentAdapter(childFragmentManager, fragments, tabList)
        mTabLayout.setupWithViewPager(mViewPager)
        TabLayoutHelper.setUpIndicatorWidth(mTabLayout)


    }

    override fun lazyLoad() {
    }
}