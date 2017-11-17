package com.hazz.kotlinmvp.ui.fragment

import android.os.Bundle
import com.hazz.kotlinmvp.ui.contract.HomeContract
import com.hazz.kotlinmvp.ui.presenter.HomePresenter
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.bean.HomeBean
import com.hazz.kotlinmvp.showToast
import kotlinx.android.synthetic.main.content_main.*

/**
 * Created by xuhao on 2017/11/8.
 *
 */

class HomeFragment : BaseFragment(), HomeContract.View{


    private var mPresenter: HomeContract.Presenter = HomePresenter()

    private var mTitle: String? = null

    private var num:Int=1

    companion object {
        fun getInstance(title : String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }


    override fun getLayoutId(): Int = R.layout.content_main



    override fun initView() {
        fab.setOnClickListener {
            num++
            mPresenter.requestHomeData(num)
        }
    }

    override fun lazyLoad() {
        mPresenter.attachView(this)


        showToast("title"+mTitle)
        tv_title.text=mTitle

        mPresenter.requestHomeData(num)


    }



    override fun showLoading() {
        tv_title.text="加载中..."
    }

    override fun dismissLoading() {
        tv_title.text="消失了..."
    }

    override fun setHomeData(homeBean: HomeBean) {
        tv_title.text=homeBean.toString()
    }


    override fun showError(msg: String) {
        tv_title.text = msg
    }







    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }






}
