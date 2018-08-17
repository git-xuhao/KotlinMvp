@file:Suppress("DEPRECATION")

package com.hazz.kotlinmvp.glide

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation

import java.security.MessageDigest

/**
 * Created by xuhao on 2017/11/29.
 * desc:
 * 1.永远不要把transform()传给你的原始resource或原始Bitmap给recycle()了，更不要放回BitmapPool，因为这些都自动完成了。值得注意的是，任何从BitmapPool取出的用于自定义图片变换的辅助Bitmap，如果不经过transform()方法返回，就必须主动放回BitmapPool或者调用recycle()回收。
 * 2.如果你从BitmapPool拿出多个Bitmap或不使用你从BitmapPool拿出的一个Bitmap，一定要返回extras给BitmapPool。
 * 3.如果你的图片处理没有替换原始resource(例如由于一张图片已经匹配了你想要的尺寸，你需要提前返回), transform()`方法就返回原始resource或原始Bitmap。
 *
 *
 */

class GlideRoundTransform @JvmOverloads constructor(dp: Int = 4) : BitmapTransformation() {

    private var radius = 0f

    init {
        this.radius = Resources.getSystem().displayMetrics.density * dp
    }

    override fun transform(pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap? {
        return roundCrop(pool, toTransform)
    }


    override fun updateDiskCacheKey(messageDigest: MessageDigest) {

    }


    private fun roundCrop(pool: BitmapPool, source: Bitmap?): Bitmap? {
        if (source == null) return null

        var result: Bitmap? = pool.get(source.width, source.height, Bitmap.Config.ARGB_8888)
        if (result == null) {
            result = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
        }

        val canvas = Canvas(result!!)
        val paint = Paint()
        paint.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.isAntiAlias = true
        val rectF = RectF(0f, 0f, source.width.toFloat(), source.height.toFloat())
        canvas.drawRoundRect(rectF, radius, radius, paint)
        return result
    }

}
