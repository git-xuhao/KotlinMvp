package com.hazz.kotlinmvp.glide

import android.graphics.*

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation

import java.security.MessageDigest

/**
 * Created by xuhao on 2017/11/27.
 * desc:
 */

class GlideRotateTransformation : BitmapTransformation() {



    override fun transform(pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap? {
        return rotateTransform(pool, toTransform)
    }

    private fun rotateTransform(bitmapPool: BitmapPool, toTransform: Bitmap): Bitmap? {

        //如果想让图片旋转 非常简单，主要借助于Matrix对象:矩阵对象，将图片转化成像素矩阵。
        val matrix = Matrix()
        //执行旋转，参数为旋转角度
        matrix.postRotate(90f)
        //将图形的像素点按照这个矩阵进行旋转
        //将矩阵加载到bitmap对象上，进行输出就可以了  如何创建Bitmap对象
        //待旋转的bitmap对象，待旋转图片的宽度，待旋转图片的高度

        return Bitmap.createBitmap(toTransform, 0, 0, toTransform.width, toTransform.height, matrix, true)
    }


    override fun updateDiskCacheKey(messageDigest: MessageDigest?) {
    }


}
