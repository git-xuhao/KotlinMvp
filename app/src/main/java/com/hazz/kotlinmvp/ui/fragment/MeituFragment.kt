package com.hazz.kotlinmvp.ui.fragment

import android.os.Bundle
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment

/**
 * Created by xuhao on 2017/11/9.
 */
class MeituFragment: BaseFragment() {


    override fun initView() {
    }


    private var mTitle:String? =null


    companion object {
        fun getInstance(title:String): MeituFragment {
            val fragment = MeituFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }


    override fun getLayoutId(): Int= R.layout.fragment_home

    override fun lazyLoad() {
//       tv_title.text=mTitle
    }

}