package com.hazz.kotlinmvp.ui.adapter

import android.content.Context
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.durationFormat
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean
import com.hazz.kotlinmvp.view.ExpandableTextView
import com.hazz.kotlinmvp.view.recyclerview.MultipleType
import com.hazz.kotlinmvp.view.recyclerview.ViewHolder
import com.hazz.kotlinmvp.view.recyclerview.adapter.CommonAdapter
import java.util.*

/**
 * Created by xuhao on 2017/11/25.
 * desc: 视频详情
 */

class VideoDetailAdapter(mContext: Context, data: ArrayList<HomeBean.Issue.Item>) :
        CommonAdapter<HomeBean.Issue.Item>(mContext, data, object : MultipleType<HomeBean.Issue.Item> {
            override fun getLayoutId(item: HomeBean.Issue.Item, position: Int): Int {
                if (position == 0) {
                    return R.layout.item_video_info
                }
                return R.layout.item_home_header

            }
        }) {

    companion object {

        private val TYPE_VIDEO_INFO = 1    //Video 信息简介
        private val TYPE_VIDEO_FOOTER = 2   //尾部
        private val ITEM_TYPE_CONTENT = 3    //item
    }


    fun addData(item: HomeBean.Issue.Item) {
        mData.clear()
        notifyDataSetChanged()
        mData.add(item)
        notifyItemInserted(0)

    }

    override fun bindData(holder: ViewHolder, data: HomeBean.Issue.Item, position: Int) {
        if (position == 0) {
            data.data?.title?.let { holder.setText(R.id.tv_title, it) }

            holder.getView<ExpandableTextView>(R.id.expand_text_view).text = data.data?.description
            //标签
            holder.setText(R.id.tv_tag, "#${data.data?.category} / ${durationFormat(data.data?.duration)}")
        }
    }
}
