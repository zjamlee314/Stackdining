package com.stackdining.www.view.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.stackdining.www.R
import com.stackdining.www.app.Constant
import com.stackdining.www.base.BaseFragment
import com.stackdining.www.contract.PersonalContract
import com.stackdining.www.model.bean.PersonalDataBean
import com.stackdining.www.presenter.PersonalPresenter
import com.stackdining.www.view.activity.PersonalInfoActivity
import kotlinx.android.synthetic.main.fragment_my.*

/**
 *  Created by Evan
 *  on 2022/2/15
 */
class MyFragment : BaseFragment<PersonalPresenter?>(), PersonalContract.IView{

    var layoutView: View? = null

    override fun providePresenter(): PersonalPresenter {
        return PersonalPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_my
    }

    override fun lazyLoad() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inintData()
        inintEvent()
    }

    /**
     * 初始化数据
     */
    fun inintData(){
            var hashMap = HashMap<String,Any>()
            mPresenter!!.personalInfo(hashMap)
    }

    /**
     * 初始化事件
     */
    fun inintEvent(){

        /**
         * 编辑个人信息
         */
        rl_edit.setOnClickListener {
            var intent = Intent(activity,PersonalInfoActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * 用户个人信息
     */
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onPersonalInfoSuccess(personalDataBean: PersonalDataBean?) {
        if(personalDataBean!!.status == Constant.OK_RESULT){
            tv_name.text = personalDataBean!!.data.nickname
            Glide.with(activity!!)
                .load(personalDataBean!!.data.avatar)
                .placeholder(R.mipmap.default_avatar)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(iv_img)
        }
    }

    override fun onPersonalInfoFailure(e: Throwable?) {
    }
}


