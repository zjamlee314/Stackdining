package com.stackdining.www.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.stackdining.www.R
import com.stackdining.www.adapter.HomeListAdapter
import com.stackdining.www.base.BaseFragment
import com.stackdining.www.contract.MainContract
import com.stackdining.www.model.bean.HomeListBean
import com.stackdining.www.presenter.MainPresenter
import com.stackdining.www.view.activity.CanteenDetailsActivity
import kotlinx.android.synthetic.main.fragment_canteen.*
import java.util.HashMap

class CanteenFragment: BaseFragment<MainPresenter?>(), MainContract.IView{
    private var mTitle: String? = null
    private var ARG_PARAM1 = "param1"
    lateinit var homeListAdapter: HomeListAdapter
    private var hasLoadData = false //是否已经加载过数据
    private var isViewPrepared = false //控件是否已经准备好

    fun newInstance(param1: String?): CanteenFragment? {
        var canteenFragment = CanteenFragment()
        var args = Bundle()
        args.putString(ARG_PARAM1, param1)
        canteenFragment.arguments = args
        return canteenFragment
    }

    override fun providePresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_canteen
    }

    override fun onDestroyView() {
        super.onDestroyView()
        hasLoadData = false
        isViewPrepared = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepared = true
        lazyLoad()

    }

    override fun lazyLoad() {
        if(userVisibleHint && isViewPrepared && !hasLoadData){
            hasLoadData = true
            var hashMap = HashMap<String,Any>()
            hashMap["limit"] = "100"
            hashMap["page"] = "1"
            mPresenter!!.homeList(hashMap)

        }

    }

    /**
     * 初始化数据
     */
    fun inintDatas(){
    }

    /**
     * 商家列表
     */
    override fun onHomeListSuccess(homeListBean: HomeListBean?) {

        homeListAdapter = HomeListAdapter()
        homeListAdapter.submitList(homeListBean!!.data)
        var layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        recy_view.layoutManager = layoutManager
        recy_view.adapter = homeListAdapter
        homeListAdapter.addOnItemChildClickListener(R.id.rl_layout) { adapter, view, position ->
            var intent = Intent(activity,CanteenDetailsActivity::class.java)
            intent.putExtra("restaurant_code", homeListBean.data[position].restaurant_code)
            startActivity(intent)
        }
    }

    override fun onHomeListFailure(e: Throwable?) {
    }

}