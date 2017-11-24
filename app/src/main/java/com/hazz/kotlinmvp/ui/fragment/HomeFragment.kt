package com.hazz.kotlinmvp.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean
import com.hazz.kotlinmvp.mvp.contract.HomeContract
import com.hazz.kotlinmvp.mvp.presenter.HomePresenter
import com.hazz.kotlinmvp.showToast
import com.hazz.kotlinmvp.ui.adapter.HomeAdapter
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by xuhao on 2017/11/8.
 * 首页精选
 */

class HomeFragment : BaseFragment(), HomeContract.View{


    private var mPresenter = HomePresenter()

    private var mTitle: String? = null

    private var num: Int = 1

    private var nextPageUrl: String? = null

    private var mHomeAdapter: HomeAdapter? = null

    private var loadingMore = false

    companion object {
        fun getInstance(title: String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    private val linearLayoutManager by lazy {
        LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }


    private val simpleDateFormat by lazy {
        SimpleDateFormat("- MMM. dd, 'Brunch' -", Locale.ENGLISH)
    }


    override fun getLayoutId(): Int = R.layout.fragment_home


    /**
     * 初始化 ViewI
     */
    override fun initView() {
        mRefreshLayout.setOnRefreshListener { mPresenter.requestHomeData(num) }
        mRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val childCount = mRecyclerView.childCount
                    val itemCount = mRecyclerView.layoutManager.itemCount
                    val firstVisibleItem = (mRecyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (firstVisibleItem + childCount == itemCount) {
                        if (!loadingMore) {
                            loadingMore = true
                            mPresenter.loadMoreData()
                        }
                    }
                }
            }

            //RecyclerView滚动的时候调用
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val currentVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()
                if (currentVisibleItemPosition == 0) {
                      toolbar.visibility=View.GONE
                } else {
                    if (mHomeAdapter?.mData!!.size > 1) {
                        toolbar.visibility = View.VISIBLE
                        val itemList = mHomeAdapter!!.mData
                        val item = itemList[currentVisibleItemPosition + mHomeAdapter!!.bannerItemSize - 1]
                        if (item.type == "textHeader") {
                            tv_header_title.text = item.data?.text
                        } else {
                            tv_header_title.text = simpleDateFormat.format(item.data?.date)
                        }
                    }
                }


            }
        })

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
        mHomeAdapter = HomeAdapter(activity, homeBean.issueList[0].itemList)
        //设置 banner 大小
        mHomeAdapter?.setBannerSize(homeBean.issueList[0].count)

        mRecyclerView.adapter = mHomeAdapter
        mRecyclerView.layoutManager = linearLayoutManager

    }

    override fun setMoreData(itemList: ArrayList<HomeBean.Issue.Item>) {
        loadingMore = false
        mHomeAdapter?.addItemData(itemList)
    }


    override fun showError(msg: String) {
        showToast(msg)
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }


}
