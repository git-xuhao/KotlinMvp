package com.hazz.kotlinmvp.ui.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseActivity
import com.hazz.kotlinmvp.mvp.model.bean.TabEntity
import com.hazz.kotlinmvp.showToast
import com.hazz.kotlinmvp.ui.fragment.CategoryFragment
import com.hazz.kotlinmvp.ui.fragment.HomeFragment
import com.hazz.kotlinmvp.ui.fragment.HotFragment
import com.hazz.kotlinmvp.ui.fragment.MeituFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/**
 * @author Jake.Ho
 * created: 2017/10/25
 * desc:
 */


class MainActivity : BaseActivity() {

    private val mTitles = arrayOf("首页精选", "分类", "热门", "美图")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment: HomeFragment? = null
    private var mCategoryFragment: CategoryFragment? = null
    private var mHotFragment: HotFragment? = null
    private var mMeiTuFragment: MeituFragment?=null

    //默认为0
    private var mIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("mTabIndex")
        }
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)

    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    //初始化底部菜单
    private fun initTab() {
        (0 until mTitles.size)
                .mapTo(mTabEntities) { TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it]) }
        //为Tab赋值
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                showToast("-----" + position)
                //切换Fragment
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })
    }

    /**
     * 切换Fragment
     * @param position 下标
     */
    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (position) {
            0 //首页
            -> if (mHomeFragment == null) {
                mHomeFragment = HomeFragment.getInstance(mTitles[position])
                transaction.add(R.id.fl_container, mHomeFragment, "home")
            } else {
                transaction.show(mHomeFragment)
            }
            1 //分类
            -> if (mCategoryFragment == null) {
                mCategoryFragment = CategoryFragment.getInstance(mTitles[position])
                transaction.add(R.id.fl_container, mCategoryFragment, "category")
            } else {
                transaction.show(mCategoryFragment)
            }
            2 //热门
            -> if ( mHotFragment== null) {
                mHotFragment = HotFragment.getInstance(mTitles[position])
                transaction.add(R.id.fl_container, mHotFragment, "hot")
            }
            else {
                transaction.show(mHotFragment)
            }

            3 //更多
            -> if (mMeiTuFragment == null) {
                mMeiTuFragment = MeituFragment.getInstance(mTitles[position])
                transaction.add(R.id.fl_container, mMeiTuFragment, "mei")
            } else {
                transaction.show(mMeiTuFragment)
            }
            else -> {

            }
        }
        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()
    }


    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        if (null != mHomeFragment) {
            transaction.hide(mHomeFragment)
        }
        if (null != mCategoryFragment) {
            transaction.hide(mCategoryFragment)
        }
        if (null != mHotFragment) {
            transaction.hide(mHotFragment)
        }
        if (null != mMeiTuFragment) {
            transaction.hide(mMeiTuFragment)
        }

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
        if (tab_layout != null) {
            outState.putInt("currTabIndex", mIndex)
        }
    }


}
