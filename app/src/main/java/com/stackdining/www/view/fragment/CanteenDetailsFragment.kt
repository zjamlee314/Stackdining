package com.stackdining.www.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.stackdining.www.R
import com.stackdining.www.adapter.CanteenDetailsAdapter
import com.stackdining.www.app.Constant
import com.stackdining.www.base.BaseFragment
import com.stackdining.www.contract.CanteenContract
import com.stackdining.www.model.bean.CanteenDetailsBean
import com.stackdining.www.model.bean.DishesListBean
import com.stackdining.www.model.bean.NewDishesListBean
import com.stackdining.www.model.bean.PublicResultBean
import com.stackdining.www.presenter.CanteenPresenter
import com.stackdining.www.show.T
import kotlinx.android.synthetic.main.fragment_canteen_details.*

class CanteenDetailsFragment: BaseFragment<CanteenPresenter?>(), CanteenContract.IView{
    private var mTitle: String? = null
    private var ARG_PARAM1 = "param1"
    private var ARG_PARAM2 = "param2"
    private var ARG_PARAM3 = "param3"
    lateinit var canteenDetailsAdapter: CanteenDetailsAdapter
    private var hasLoadData = false //是否已经加载过数据
    private var isViewPrepared = false //控件是否已经准备好
    var title = ""
    var code = ""
    var clickPosition = 0

    fun newInstance(param1: String?,param2: String?,param3: Int): CanteenDetailsFragment? {
        var canteenFragment = CanteenDetailsFragment()
        var args = Bundle()
        args.putString(ARG_PARAM1, param1)
        args.putString(ARG_PARAM2, param2)
        args.putInt(ARG_PARAM3, param3)
        canteenFragment.arguments = args
        return canteenFragment
    }

    override fun providePresenter(): CanteenPresenter {
        return CanteenPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_canteen_details
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

    @SuppressLint("UseRequireInsteadOfGet")
    override fun lazyLoad() {
        if(userVisibleHint && isViewPrepared && !hasLoadData){
            title = arguments!!.getString(ARG_PARAM2)!!
            code = arguments!!.getString(ARG_PARAM1)!!
            clickPosition = arguments!!.getInt(ARG_PARAM3)!!

            tv_name.text = title
            hasLoadData = true
//            var hashMap = HashMap<String,Any>()
//            hashMap["restaurant_code"] = code
//            hashMap["limit"] = "100"
//            hashMap["page"] = "1"
//            mPresenter!!.dishes_list(hashMap)

            var map = java.util.HashMap<String, Any>()
            map["restaurant_code"] = code
            mPresenter!!.new_dishes_list(map)

        }

    }

    /**
     * 初始化数据
     */
    fun inintDatas(){
    }

    override fun onAboutSuccess(canteenDetailsBean: CanteenDetailsBean?) {
    }

    override fun onAboutFailure(e: Throwable?) {
    }

    /**
     * 菜品列表
     */
    override fun onDishesListSuccess(dishesListBean: DishesListBean?) {
//        if(dishesListBean!!.status == Constant.OK_RESULT){
//           canteenDetailsAdapter = CanteenDetailsAdapter()
//           canteenDetailsAdapter.submitList(dishesListBean!!.data)
//            recy_view.layoutManager = GridLayoutManager(activity, 2)
//            recy_view.adapter = canteenDetailsAdapter
//        }else{
//            T.showShort(activity,dishesListBean.msg)
//        }
    }

    override fun onDishesListFailure(e: Throwable?) {
    }

    override fun onSaveSuccess(publicResultBean: PublicResultBean?) {
    }

    override fun onSaveFailure(e: Throwable?) {
    }

    /**
     * 新 菜单列表
     */
    override fun onNewDishesListSuccess(newDishesListBean: NewDishesListBean?) {
        if(newDishesListBean!!.status == Constant.OK_RESULT){
            canteenDetailsAdapter = CanteenDetailsAdapter()
            canteenDetailsAdapter.submitList(newDishesListBean!!.data[clickPosition].food_list)
            recy_view.layoutManager = GridLayoutManager(activity, 2)
            recy_view.adapter = canteenDetailsAdapter
        }else{
            T.showShort(activity,newDishesListBean.msg)
        }
    }

    override fun onNewDishesListFailure(e: Throwable?) {
    }

}