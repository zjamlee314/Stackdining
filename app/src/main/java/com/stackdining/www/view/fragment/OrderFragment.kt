package com.stackdining.www.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.stackdining.www.R
import com.stackdining.www.base.BaseFragment
import com.stackdining.www.contract.LoginContract
import com.stackdining.www.model.bean.LoginBean
import com.stackdining.www.model.bean.PublicResultBean
import com.stackdining.www.presenter.LoginPresenter
import java.util.*

/**
 *  Created by Evan
 *  on 2022/2/15
 */
class OrderFragment : BaseFragment<LoginPresenter?>(), LoginContract.IView{

    var layoutView: View? = null

    override fun providePresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_order
    }

    override fun lazyLoad() {
    }

    @SuppressLint("Range")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inintData()
        inintEvent()
    }

    /**
     * 初始化数据
     */
    fun inintData(){

    }

    /**
     * 初始化事件
     */
    fun inintEvent(){

    }

    override fun onSendVerificationCodeSuccess(publicResultBean: PublicResultBean?) {
    }

    override fun onSendVerificationCodeFailure(e: Throwable?) {
    }

    override fun onLoginCodeSuccess(loginBean: LoginBean?) {
    }

    override fun onLoginCodeFailure(e: Throwable?) {
    }

    override fun onLoginPwdSuccess(loginBean: LoginBean?) {
    }

    override fun onLoginPwdFailure(e: Throwable?) {
    }

}


