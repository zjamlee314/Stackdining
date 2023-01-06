package com.stackdining.www.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import com.stackdining.www.R
import com.stackdining.www.model.bean.HomeListBean
import com.stackdining.www.utils.ImageUtil
import com.stackdining.www.utils.StringUtils

class HomeListAdapter : BaseQuickAdapter<HomeListBean.DataDTO, QuickViewHolder>() {

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): QuickViewHolder {
        // 返回一个 ViewHolder
        return QuickViewHolder(R.layout.item_home_list, parent)
    }
    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: HomeListBean.DataDTO?) {

        holder.setText(R.id.tv_name,item!!.name)
        holder.setText(R.id.tv_click,item!!.distance + context.getString(R.string.Miles) + " • " + item!!.reviews + context.getString(R.string.Reviews))
        holder.setText(R.id.tv_score,StringUtils.object2String(item!!.score))

        var iv_bg = holder.getView<ImageView>(R.id.iv_bg)
        ImageUtil.GlideDefaultImgRadius(context,R.mipmap.home_bg,item!!.background_img_url,1,iv_bg)

        var iv_logo = holder.getView<ImageView>(R.id.iv_logo)
        ImageUtil.GlideDefaultImgRadius(context,R.mipmap.home_bg,item!!.logo_img_url,4,iv_logo)

    }

}