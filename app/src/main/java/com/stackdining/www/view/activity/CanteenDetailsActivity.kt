package com.stackdining.www.view.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.stackdining.www.R
import com.stackdining.www.app.Constant
import com.stackdining.www.base.BaseActivity
import com.stackdining.www.contract.CanteenContract
import com.stackdining.www.model.bean.CanteenDetailsBean
import com.stackdining.www.model.bean.DishesListBean
import com.stackdining.www.model.bean.NewDishesListBean
import com.stackdining.www.model.bean.PublicResultBean
import com.stackdining.www.presenter.CanteenPresenter
import com.stackdining.www.show.T
import com.stackdining.www.utils.ImageUtil
import com.stackdining.www.utils.StatusBarUtil
import com.stackdining.www.utils.StringUtils
import com.stackdining.www.utils.TabPagerAdapter
import com.stackdining.www.view.fragment.CanteenDetailsFragment
import kotlinx.android.synthetic.main.activity_canteen_details3.*
import kotlinx.android.synthetic.main.canteen_details_header.*

/**
 *  Created by Evan
 *  on 2022/12/27
 */
class CanteenDetailsActivity : BaseActivity<CanteenPresenter>() , CanteenContract.IView{

    var restaurant_code = ""
    lateinit var tabPagerAdapter: TabPagerAdapter
    var mTitles = arrayOfNulls<String>(30)

    lateinit var ndlbean: NewDishesListBean
    var collectFlag = false

    override fun providePresenter(): CanteenPresenter {
        return CanteenPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_canteen_details3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this, false)
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this)
        //true=黑色字体  false=白色
        StatusBarUtil.setStatusBarDarkTheme(this, true)

        toolbar!!.setContentInsetsAbsolute(0, 0)
        appbarlayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appbarlayout, verticalOffset ->
            var percent = Math.abs(verticalOffset * 1.0f) / appbarlayout.totalScrollRange //滑动比例
            if (percent > 0.8) {
                rl_title!!.visibility = View.VISIBLE
                var alpha = 1 - (1 - percent) * 5 //渐变变换
                rl_title!!.alpha = alpha
            } else {
                rl_title!!.visibility = View.GONE
            }
        })

        inintDatas()
        innintEvents()
    }

    /**
     * 初始化数据
     */
    fun inintDatas(){
        restaurant_code = StringUtils.object2String(intent.getStringExtra("restaurant_code"))

        var hashMap = HashMap<String,Any>()
        hashMap["restaurant_code"] = restaurant_code
        mPresenter!!.about(hashMap)

        var map = HashMap<String,Any>()
        map[ "restaurant_code"] = restaurant_code
        mPresenter!!.new_dishes_list(map)

    }

    /**
     * 初始化事件
     */
    fun innintEvents(){

        tv_back.setOnClickListener {
            finish()
        }

        ivReturn.setOnClickListener {
            finish()
        }

        /**
         * 收藏店铺
         */
        iv_collect.setOnClickListener {

            var hashMap = HashMap<String,Any>()
            hashMap["restaurant_code"] = restaurant_code
            mPresenter!!.save(hashMap)
        }

        iv_collect_black.setOnClickListener {
            var hashMap = HashMap<String,Any>()
            hashMap["restaurant_code"] = restaurant_code
            mPresenter!!.save(hashMap)
        }
    }

    private fun getTabs(): List<String>? {
        var tabs: MutableList<String> = java.util.ArrayList()
        for (i in 0..(ndlbean.data.size - 1)){
            tabs.add("Tab" + i)
        }
        return tabs
    }

    private fun getFragments(): List<Fragment>? {
        var fragmentList: MutableList<Fragment> = java.util.ArrayList()
        for (i in 0..(ndlbean.data.size - 1)){
            fragmentList.add(CanteenDetailsFragment().newInstance(restaurant_code,mTitles[i],i)!!)
        }
        return fragmentList
    }

    /**
     * 餐厅详情
     */
    override fun onAboutSuccess(canteenDetailsBean: CanteenDetailsBean?) {
        tv_name.text = StringUtils.object2String(canteenDetailsBean!!.data.restaurant_name)
        var iv_bg = findViewById<ImageView>(R.id.iv_bg)
        ImageUtil.GlideDefaultImgRadius(this,R.mipmap.home_bg,canteenDetailsBean!!.data.background_img_url,1,iv_bg)
        /**
         * 评分
         */
        if(canteenDetailsBean!!.data.score == 0){
            iv_level_1.setImageResource(R.mipmap.level_no)
            iv_level_2.setImageResource(R.mipmap.level_no)
            iv_level_3.setImageResource(R.mipmap.level_no)
            iv_level_4.setImageResource(R.mipmap.level_no)
            iv_level_5.setImageResource(R.mipmap.level_no)
        }else if(canteenDetailsBean!!.data.score == 1){
            iv_level_1.setImageResource(R.mipmap.level)
            iv_level_2.setImageResource(R.mipmap.level_no)
            iv_level_3.setImageResource(R.mipmap.level_no)
            iv_level_4.setImageResource(R.mipmap.level_no)
            iv_level_5.setImageResource(R.mipmap.level_no)
        }else if(canteenDetailsBean!!.data.score > 1 && canteenDetailsBean!!.data.score < 2){
            iv_level_1.setImageResource(R.mipmap.level)
            iv_level_2.setImageResource(R.mipmap.level_half)
            iv_level_3.setImageResource(R.mipmap.level_no)
            iv_level_4.setImageResource(R.mipmap.level_no)
            iv_level_5.setImageResource(R.mipmap.level_no)
        }else if(canteenDetailsBean!!.data.score == 2){
            iv_level_1.setImageResource(R.mipmap.level)
            iv_level_2.setImageResource(R.mipmap.level)
            iv_level_3.setImageResource(R.mipmap.level_no)
            iv_level_4.setImageResource(R.mipmap.level_no)
            iv_level_5.setImageResource(R.mipmap.level_no)
        }else if(canteenDetailsBean!!.data.score > 2 && canteenDetailsBean!!.data.score < 3){
            iv_level_1.setImageResource(R.mipmap.level)
            iv_level_2.setImageResource(R.mipmap.level)
            iv_level_3.setImageResource(R.mipmap.level_half)
            iv_level_4.setImageResource(R.mipmap.level_no)
            iv_level_5.setImageResource(R.mipmap.level_no)
        }else if(canteenDetailsBean!!.data.score == 3){
            iv_level_1.setImageResource(R.mipmap.level)
            iv_level_2.setImageResource(R.mipmap.level)
            iv_level_3.setImageResource(R.mipmap.level)
            iv_level_4.setImageResource(R.mipmap.level_no)
            iv_level_5.setImageResource(R.mipmap.level_no)
        }else if(canteenDetailsBean!!.data.score > 3 && canteenDetailsBean!!.data.score < 4){
            iv_level_1.setImageResource(R.mipmap.level)
            iv_level_2.setImageResource(R.mipmap.level)
            iv_level_3.setImageResource(R.mipmap.level)
            iv_level_4.setImageResource(R.mipmap.level_half)
            iv_level_5.setImageResource(R.mipmap.level_no)
        }else if(canteenDetailsBean!!.data.score == 4){
            iv_level_1.setImageResource(R.mipmap.level)
            iv_level_2.setImageResource(R.mipmap.level)
            iv_level_3.setImageResource(R.mipmap.level)
            iv_level_4.setImageResource(R.mipmap.level)
            iv_level_5.setImageResource(R.mipmap.level_no)
        }else if(canteenDetailsBean!!.data.score > 4 && canteenDetailsBean!!.data.score < 5){
            iv_level_1.setImageResource(R.mipmap.level)
            iv_level_2.setImageResource(R.mipmap.level)
            iv_level_3.setImageResource(R.mipmap.level)
            iv_level_4.setImageResource(R.mipmap.level)
            iv_level_5.setImageResource(R.mipmap.level_half)
        }else if(canteenDetailsBean!!.data.score >= 5){
            iv_level_1.setImageResource(R.mipmap.level)
            iv_level_2.setImageResource(R.mipmap.level)
            iv_level_3.setImageResource(R.mipmap.level)
            iv_level_4.setImageResource(R.mipmap.level)
            iv_level_5.setImageResource(R.mipmap.level)
        }
        tv_score.text = StringUtils.object2String(canteenDetailsBean!!.data.score)
        tv_reviews.text = StringUtils.object2String(canteenDetailsBean!!.data.reviews) + "  " + getString(R.string.Reviews)
        collectFlag = canteenDetailsBean.data.isIs_collect
        /**
         * 是否收藏
         */
        if(canteenDetailsBean.data.isIs_collect){
            iv_collect.setImageResource(R.mipmap.details_collect_true)
            iv_collect_black.setImageResource(R.mipmap.details_collect_true)
        }else{
            iv_collect.setImageResource(R.mipmap.details_collect)
            iv_collect_black.setImageResource(R.mipmap.details_collect_black)
        }
    }

    override fun onAboutFailure(e: Throwable?) {
    }

    override fun onDishesListSuccess(dishesListBean: DishesListBean?) {
    }

    override fun onDishesListFailure(e: Throwable?) {
    }

    /**
     * 收藏店铺
     */
    override fun onSaveSuccess(publicResultBean: PublicResultBean?) {
        if(publicResultBean!!.status ==  Constant.OK_RESULT){
            if(collectFlag){
                collectFlag = false
                iv_collect.setImageResource(R.mipmap.details_collect)
            }else{
                collectFlag = true
                iv_collect.setImageResource(R.mipmap.details_collect_true)
            }
        }
        T.showShort(this,publicResultBean.msg)
    }

    override fun onSaveFailure(e: Throwable?) {
    }

    /**
     * 新 菜单列表
     */
    override fun onNewDishesListSuccess(newDishesListBean: NewDishesListBean?) {
       if(newDishesListBean!!.status == Constant.OK_RESULT){

           ndlbean = newDishesListBean
           mTitles= arrayOfNulls<String>(ndlbean.data.size)
           for (i in 0..(newDishesListBean.data.size - 1)){
               mTitles[i] = newDishesListBean.data[i].category
           }
           tabPagerAdapter = TabPagerAdapter(this!!.supportFragmentManager, getTabs(), getFragments())
           viewPager.adapter = tabPagerAdapter
           sliding_tablayout.setViewPager(viewPager,mTitles)
           sliding_tablayout.getTitleView(0).textSize = 18F
       }
    }

    override fun onNewDishesListFailure(e: Throwable?) {
    }


}