package com.hazz.kotlinmvp.mvp.presenter

import com.hazz.kotlinmvp.base.BasePresenter
import com.hazz.kotlinmvp.mvp.contract.CategoryContract
import com.hazz.kotlinmvp.mvp.model.CategoryModel

/**
 * Created by xuhao on 2017/11/29.
 * desc:
 */
class CategoryPresenter:BasePresenter<CategoryContract.View>(),CategoryContract.Presenter {

    private val categoryModel:CategoryModel by lazy {
        CategoryModel()
    }

    /**
     * 获取分类
     */
    override fun getCategoryData() {
                
    }
}