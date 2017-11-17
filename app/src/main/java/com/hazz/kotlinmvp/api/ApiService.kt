package com.hazz.kotlinmvp.api

import com.hazz.kotlinmvp.bean.HomeBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by xuhao on 2017/11/16.
 */

interface ApiService{



    /**
     * 首页精选
     */
    @GET("v2/feed?")
    fun getFirstHomeData(@Query("num") num:Int): Observable<HomeBean>

}