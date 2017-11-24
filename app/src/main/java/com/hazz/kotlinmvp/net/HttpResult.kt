package com.hazz.kotlinmvp.net

/**
 * Created by xuhao on 2017/11/16.
 */
class HttpResult<T>(val error :Boolean,
                    val results:T)