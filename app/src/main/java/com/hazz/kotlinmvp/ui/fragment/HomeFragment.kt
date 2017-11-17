package com.hazz.kotlinmvp.ui.fragment

import android.os.Bundle
import com.hazz.kotlinmvp.MainContract
import com.hazz.kotlinmvp.MainPresenter
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.bean.FuckGoods
import com.hazz.kotlinmvp.showToast
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * Created by xuhao on 2017/11/8.
 *
 */

class HomeFragment : BaseFragment(),MainContract.View{


    private lateinit var mPresenter:MainContract.Presenter


    override fun showLoading() {
        tv_title.text="加载中..."
    }

    override fun dismissLoading() {
        tv_title.text="消失了..."
    }

    override fun showAndroidData(fuckGoods: List<FuckGoods>) {
        tv_title.text=fuckGoods.toString()
    }

    override fun showError(msg: String) {
        tv_title.text = msg
    }


    private var mTitle: String? = null


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

    override fun lazyLoad() {
        mPresenter = MainPresenter()
        mPresenter.attachView(this)


        showToast("title"+mTitle)
        tv_title.text=mTitle

        mPresenter.getAndroidData(1)


    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }






}
