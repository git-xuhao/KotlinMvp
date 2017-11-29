package com.hazz.kotlinmvp.mvp.model.bean

import java.io.Serializable

/**
 * Created by xuhao on 2017/11/29.
 * desc:分类 Bean
 */
data class CategoryBean(val id: Long, val name: String, val description: String, val bgPicture: String, val bgColor: String, val headerImage: String) : Serializable
