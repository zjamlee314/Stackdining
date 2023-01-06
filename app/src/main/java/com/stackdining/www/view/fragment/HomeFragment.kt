package com.stackdining.www.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.stackdining.www.R
import com.stackdining.www.base.BaseFragment
import com.stackdining.www.contract.MainContract
import com.stackdining.www.model.bean.HomeListBean
import com.stackdining.www.presenter.MainPresenter
import com.stackdining.www.utils.TabPagerAdapter
import kotlinx.android.synthetic.main.fragment_home2.*
import java.util.*

/**
 *  Created by Evan
 *  on 2022/2/15
 */
class HomeFragment : BaseFragment<MainPresenter?>(), MainContract.IView{

    var layoutView: View? = null
    lateinit var tabPagerAdapter: TabPagerAdapter
    private var mTitles = arrayOf(
        "Recommend", "Highest Sales","Restaurant Rating"
    )
    private var mFragments = ArrayList<Fragment>()
    lateinit var canteenFragment: CanteenFragment

    override fun providePresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_home2
    }

    override fun lazyLoad() {
    }

    @SuppressLint("Range")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //StatusBarUtil.setTranslucentStatus(activity)
        toolbar!!.setContentInsetsAbsolute(0, 0)

        appbarlayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appbarlayout, verticalOffset ->
            var percent = Math.abs(verticalOffset * 1.0f) / appbarlayout.totalScrollRange //滑动比例
            if (percent > 0.8) {
                ll_layout!!.visibility = View.VISIBLE
                var alpha = 1 - (1 - percent) * 5 //渐变变换
                ll_layout!!.alpha = alpha
            } else {
                ll_layout!!.visibility = View.GONE
            }
        })
        inintData()
        inintEvent()
    }

    /**
     * 初始化数据
     */
    @SuppressLint("UseRequireInsteadOfGet")
    fun inintData(){

        tabPagerAdapter = TabPagerAdapter(activity!!.supportFragmentManager, getTabs(), getFragments())
        viewPager.adapter = tabPagerAdapter
        sliding_tablayout.setViewPager(viewPager,mTitles)
        sliding_tablayout.getTitleView(0).textSize = 18F
    }

    /**
     * 初始化事件
     */
    fun inintEvent(){

    }

    private fun getTabs(): List<String>? {
        var tabs: MutableList<String> = java.util.ArrayList()
        tabs.add("Tab1")
        tabs.add("Tab2")
        tabs.add("Tab3")
        return tabs
    }

    private fun getFragments(): List<Fragment>? {
        var fragmentList: MutableList<Fragment> = java.util.ArrayList()
        fragmentList.add(CanteenFragment().newInstance("Tab1")!!)
        fragmentList.add(CanteenFragment().newInstance("Tab2")!!)
        fragmentList.add(CanteenFragment().newInstance("Tab3")!!)
        return fragmentList
    }

    /**
     * 获取首页列表
     */
    override fun onHomeListSuccess(homeListBean: HomeListBean?) {
    }

    override fun onHomeListFailure(e: Throwable?) {
    }


}


