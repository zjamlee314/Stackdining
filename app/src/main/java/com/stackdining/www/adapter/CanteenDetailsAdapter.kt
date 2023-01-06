package com.stackdining.www.adapter

import android.content.Context
import android.graphics.Paint
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import com.stackdining.www.R
import com.stackdining.www.model.bean.NewDishesListBean
import com.stackdining.www.utils.ImageUtil
import com.stackdining.www.utils.StringUtils

class CanteenDetailsAdapter : BaseQuickAdapter<NewDishesListBean.DataDTO.FoodListDTO, QuickViewHolder>() {

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): QuickViewHolder {
        // 返回一个 ViewHolder
        return QuickViewHolder(R.layout.item_canteen_details, parent)
    }
    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: NewDishesListBean.DataDTO.FoodListDTO?) {

//        holder.setText(R.id.tv_name,item!!.restaurant_name)
//
//        holder.setText(R.id.tv_score,StringUtils.object2String(item!!.score))
//
//        var iv_bg = holder.getView<ImageView>(R.id.iv_bg)
//        ImageUtil.GlideDefaultImgRadius(context,R.mipmap.home_bg,item!!.background_img_url,1,iv_bg)
//
        var iv_img = holder.getView<ImageView>(R.id.iv_img)
        ImageUtil.GlideDefaultImgRadius(context,R.mipmap.home_bg,item!!.picture_url,1,iv_img)

        holder.setText(R.id.tv_name,item!!.dish_name)
        holder.setText(R.id.tv_money,"$ " + item!!.discount)
        if(!StringUtils.object2String(item!!.original_price).equals("")){
            var tv_original_price = holder.getView<TextView>(R.id.tv_original_price)
            tv_original_price.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            holder.setText(R.id.tv_original_price,"$ " + item!!.original_price)
        }


    }

}