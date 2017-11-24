package com.hazz.kotlinmvp.mvp.model.bean

import java.util.*

/**
 * Created by xuhao on 2017/11/16.
 */
data class FuckGoods(
        private var _id: String,
        private var createdAt: String,
        private var desc: String,
        private var images: Array<String>?,
        private var publishedAt: String,
        private var source: String,
        private var type: String,
        private var url: String,
        private var used: Boolean,
        private var who: String

){
    fun hasImg():Boolean {
        return images!=null
    }
    fun create() = createdAt.substring(0,10)



    override fun toString(): String {
        return "FuckGoods(_id='$_id', createdAt='$createdAt', desc='$desc', images=${Arrays.toString(images)}, publishedAt='$publishedAt', source='$source', type='$type', url='$url', used=$used, who='$who')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FuckGoods

        if (_id != other._id) return false
        if (createdAt != other.createdAt) return false
        if (desc != other.desc) return false
        if (!Arrays.equals(images, other.images)) return false
        if (publishedAt != other.publishedAt) return false
        if (source != other.source) return false
        if (type != other.type) return false
        if (url != other.url) return false
        if (used != other.used) return false
        if (who != other.who) return false

        return true
    }

    override fun hashCode(): Int {
        var result = _id.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + desc.hashCode()
        result = 31 * result + Arrays.hashCode(images)
        result = 31 * result + publishedAt.hashCode()
        result = 31 * result + source.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + url.hashCode()
        result = 31 * result + used.hashCode()
        result = 31 * result + who.hashCode()
        return result
    }


}