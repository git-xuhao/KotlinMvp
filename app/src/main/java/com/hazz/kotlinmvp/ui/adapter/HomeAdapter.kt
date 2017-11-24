package com.hazz.kotlinmvp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.durationFormat
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
        private val ITEM_TYPE_TEXT_HEADER=2   //textHeader
        private val ITEM_TYPE_CONTENT = 3    //item
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
        return when {
            position == 0 ->
                ITEM_TYPE_BANNER
            mData[position+bannerItemSize-1].type == "textHeader" ->
                ITEM_TYPE_TEXT_HEADER
            else ->
                ITEM_TYPE_CONTENT
        }
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
                val bannerItemData: ArrayList<HomeBean.Issue.Item> = mData.take(bannerItemSize).toCollection(ArrayList())
                val bannerFeedList: ArrayList<String> = ArrayList()
                val bannerTitleList: ArrayList<String> = ArrayList()
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
            //TextHeader
            ITEM_TYPE_TEXT_HEADER ->{
                holder.setText(R.id.tvHeader, mData[position+bannerItemSize-1].data?.text!!)
            }

            //content
            ITEM_TYPE_CONTENT ->{
                videoItem(holder,mData[position+bannerItemSize-1])
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
            ITEM_TYPE_TEXT_HEADER ->
                ViewHolder(inflaterView(R.layout.item_home_header, parent))
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


    /**
     * 加载 content item
     */
     private fun videoItem(holder: ViewHolder,item:HomeBean.Issue.Item){
        val itemData = item.data

        val cover = itemData?.cover?.feed
        var avatar = itemData?.author?.icon
        val defAvatar = R.mipmap.default_avatar
        var tagText:String?="# "

        // 作者出处为空，就显获取提供者的信息
        if(avatar.isNullOrEmpty()){
             avatar= itemData?.provider?.icon
        }
        // 加载封页图
        Glide.with(mContext).load(cover).into(holder.getView(R.id.iv_cover_feed))

        // 如果提供者信息为空，就显示默认
        if(avatar.isNullOrEmpty()){
            Glide.with(mContext).load(defAvatar).into(holder.getView(R.id.iv_avatar))
        }else{
            Glide.with(mContext).load(avatar).into(holder.getView(R.id.iv_avatar))
        }
        holder.setText(R.id.tv_title,itemData?.title!!)

        //遍历标签
        itemData.tags.take(4).forEach{
            tagText +=(it.name+"/")
        }
        // 格式化时间
        val timeFormat = durationFormat(itemData.duration)

        tagText+=timeFormat

        holder.setText(R.id.tv_tag, tagText!!)

        holder.setText(R.id.tv_category,"#"+itemData.category)


    }


}
