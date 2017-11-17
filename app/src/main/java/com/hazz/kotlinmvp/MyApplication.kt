package com.hazz.kotlinmvp

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import kotlin.properties.Delegates

/**
 * Created by xuhao on 2017/11/16.
 */

class MyApplication : Application(){



    companion object {

        private val TAG = "MyApplication"

        @JvmStatic
        var context: Context by Delegates.notNull()
            private set


    }



    override fun onCreate() {
        super.onCreate()

        context = applicationContext

        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)


    }




    private val mActivityLifecycleCallbacks = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Log.d(TAG, "onCreated: " + activity.componentName.className)
        }

        override fun onActivityStarted(activity: Activity) {
            Log.d(TAG, "onStart: " + activity.componentName.className)
        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

        }

        override fun onActivityDestroyed(activity: Activity) {
            Log.d(TAG, "onDestroy: " + activity.componentName.className)
        }
    }


}
