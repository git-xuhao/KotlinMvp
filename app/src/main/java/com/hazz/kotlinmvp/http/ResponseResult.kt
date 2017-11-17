package com.hazz.kotlinmvp.http

/**
 * Created by xuhao on 2017/11/16.
 */
class ResponseResult<T>(val error :Boolean,
                            val results:T)