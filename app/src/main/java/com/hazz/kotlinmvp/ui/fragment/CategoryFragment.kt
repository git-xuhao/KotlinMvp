package com.hazz.kotlinmvp.ui.fragment

import android.os.Bundle
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.showToast

/**
 * Created by xuhao on 2017/11/8.
 * 分类
 */

class CategoryFragment : BaseFragment() {


    private var mTitle: String? = null


    /**
     * 伴生对象
     */
    companion object {
        fun getInstance(title: String): CategoryFragment {
            val fragment = CategoryFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }



    override fun getLayoutId(): Int = R.layout.fragment_home



    override fun initView() {
    }

    override fun lazyLoad() {
        showToast("分类title"+mTitle)
//        tv_title.text=mTitle
    }



}
