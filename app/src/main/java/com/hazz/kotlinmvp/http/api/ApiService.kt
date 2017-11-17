package com.hazz.kotlinmvp.http.api

import com.hazz.kotlinmvp.bean.FuckGoods
import com.hazz.kotlinmvp.http.ResponseResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by xuhao on 2017/11/16.
 */

interface ApiService{


    /**
     * Android所有数据
     */
    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page:Int): Observable<ResponseResult<List<FuckGoods>>>
}