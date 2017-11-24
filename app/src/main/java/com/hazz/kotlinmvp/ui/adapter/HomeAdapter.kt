package com.hazz.kotlinmvp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean
import com.hazz.kotlinmvp.view.recyclerview.ViewHolder
import com.hazz.kotlinmvp.view.recyclerview.adapter.CommonAdapter
import io.reactivex.Observable

/**
 * Created by xuhao on 2017/11/23.
 * desc: 首页精选的 Adapter
 */

class HomeAdapter(context: Context, data: ArrayList<HomeBean.Issue.Item>)
    : CommonAdapter<HomeBean.Issue.Item>(context, data, -1) {


    private var mContext: Context? = null
    // banner 作为 RecyclerView 的第一项
    private var bannerItemSize = 0

    init {
        mContext = context
    }

    companion object {

        private val ITEM_TYPE_BANNER = 1    //Banner 类型

        private val ITEM_TYPE_CONTENT = 2    //item
    }

    /**
     * 设置 Banner 大小
     */
    fun setBannerSize(count: Int) {
        bannerItemSize = count
    }


    /**
     * 得到 Item 的类型
     */
    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return ITEM_TYPE_BANNER
        }
        return ITEM_TYPE_CONTENT
    }


    /**
     *  得到 RecyclerView Item 数量（Banner 作为一个 item）
     */
    override fun getItemCount(): Int {
        return when {
            mData.size > bannerItemSize -> mData.size - bannerItemSize + 1
            mData.isEmpty() -> 0
            else -> 1
        }
    }

    /**
     * 绑定布局
     */
    override fun bindData(holder: ViewHolder, data: HomeBean.Issue.Item, position: Int) {
        when (getItemViewType(position)) {
        //Banner
            ITEM_TYPE_BANNER -> {
                var bannerItemData: ArrayList<HomeBean.Issue.Item> = mData.take(bannerItemSize).toCollection(ArrayList())

                var bannerFeedList: ArrayList<String> = ArrayList()

                var bannerTitleList: ArrayList<String> = ArrayList()
                //取出banner 显示的 img 和 Title
                Observable.fromIterable(bannerItemData)
                        .subscribe({ list ->
                            bannerFeedList.add(list.data!!.cover.feed)
                            bannerTitleList.add(list.data.title)
                        })

                //设置 banner
                holder.getView<BGABanner>(R.id.banner).setAutoPlayAble(bannerFeedList.size > 1)
                holder.getView<BGABanner>(R.id.banner).setData(bannerFeedList, bannerTitleList)
                holder.getView<BGABanner>(R.id.banner).setAdapter(object : BGABanner.Adapter<ImageView, String> {
                    override fun fillBannerItem(bgaBanner: BGABanner?, imageView: ImageView?, feedImageUrl: String?, position: Int) {
                        Glide.with(mContext)
                                .load(feedImageUrl)
                                .into(imageView)

                    }
                })
                holder.getView<BGABanner>(R.id.banner).setDelegate { bgaBanner, view, any, i ->

                }
            }

        }

    }

    /**
     *  创建布局
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            ITEM_TYPE_BANNER ->
                ViewHolder(inflaterView(R.layout.item_home_banner, parent))
            ITEM_TYPE_CONTENT ->
                ViewHolder(inflaterView(R.layout.item_home_content, parent))
            else ->
                ViewHolder(inflaterView(R.layout.item_home_content, parent))
        }
    }


    /**
     * 加载布局
     */
    private fun inflaterView(mLayoutId: Int, parent: ViewGroup): View {
        //创建view
        val view = mInflater?.inflate(mLayoutId, parent, false)
        return view!!
    }


}
