package com.hazz.kotlinmvp.ui.adapter

import android.content.Context
import android.widget.ImageView
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.durationFormat
import com.hazz.kotlinmvp.glide.GlideApp
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean
import com.hazz.kotlinmvp.view.recyclerview.ViewHolder
import com.hazz.kotlinmvp.view.recyclerview.adapter.CommonAdapter

/**
 * Created by xuhao on 2017/12/7.
 * desc: 关注   水平的 RecyclerViewAdapter
 */
class FollowHorizontalAdapter(mContext: Context, categoryList: ArrayList<HomeBean.Issue.Item>, layoutId: Int) :
        CommonAdapter<HomeBean.Issue.Item>(mContext, categoryList, layoutId) {

    /**
     * 绑定数据
     */
    override fun bindData(holder: ViewHolder, data: HomeBean.Issue.Item, position: Int) {
        val horizontalItemData = data.data
        holder.setImagePath(R.id.iv_cover_feed,object :ViewHolder.HolderImageLoader(data.data?.cover?.feed!!){
            override fun loadImage(iv: ImageView, path: String) {
                // 加载封页图
                GlideApp.with(mContext)
                        .load(path)
                        .placeholder(R.drawable.placeholder_banner)
                        .into(holder.getView(R.id.iv_cover_feed))
            }

        })

        //横向 RecyclerView 封页图下面标题
        holder.setText(R.id.tv_title,horizontalItemData?.title!!)

        // 格式化时间
        val timeFormat = durationFormat(horizontalItemData.duration)

        if (data.data.tags.isNotEmpty()) {
            //标签
            holder.setText(R.id.tv_tag, "#${data.data.tags[0].name} / $timeFormat")
        }

    }


}
