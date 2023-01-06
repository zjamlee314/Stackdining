package com.stackdining.www.view.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import cn.jpush.android.api.JPushInterface
import com.stackdining.www.R
import com.stackdining.www.app.Constant
import com.stackdining.www.app.StackDinApplication
import com.stackdining.www.base.BaseActivity
import com.stackdining.www.contract.LoginContract
import com.stackdining.www.model.bean.LoginBean
import com.stackdining.www.model.bean.PublicResultBean
import com.stackdining.www.presenter.LoginPresenter
import com.stackdining.www.show.T
import com.stackdining.www.utils.StringUtils
import kotlinx.android.synthetic.main.activity_phone_login.*
import java.util.HashMap

class PhoneLoginActivity : BaseActivity<LoginPresenter>() ,LoginContract.IView{

    /**
     * 是否查看密码
     */
    var flag  = false

    override fun providePresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_phone_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("-----------", JPushInterface.getRegistrationID(this))
        inintEvents()
    }

    /**
     * 初始化事件
     */
    fun inintEvents(){

        /**
         * 输入手机号
         */
        et_phone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.length >= 1) {
                    ll_et_layout.background = resources.getDrawable(R.drawable.phone_login_et_bg)
                }else{
                    ll_et_layout.background = resources.getDrawable(R.drawable.phone_login_bg)
                }

            }
        })

        /**
         * 获取验证码
         */
        btn_next.setOnClickListener {

            if(ll_pwd_layout.isVisible){
                if(StringUtils.object2String(et_phone.text).length == 10 && StringUtils.object2String(et_pwd.text).length > 1){
                    var hashMap = HashMap<String,Any>()
                    hashMap["name"] = StringUtils.object2String(et_phone.text)
                    hashMap["password"] = StringUtils.object2String(et_pwd.text)
                    mPresenter.loginPwd(hashMap)
                }else{
                    return@setOnClickListener
                }
            }else{
                if(StringUtils.object2String(et_phone.text).length == 10){
                    var hashMap = HashMap<String,Any>()
                    hashMap["phoneNumber"] = StringUtils.object2String(et_phone.text)
                    hashMap["countryCode"] = "1"
                    mPresenter.sendVerification(hashMap)
                }else{
                    return@setOnClickListener
                }
            }
        }

        /**
         * 账号密码登录
         */
        tv_pwd_login.setOnClickListener {

            ll_pwd_layout.visibility = View.VISIBLE
            tv_pwd_login.visibility = View.GONE
            tv_verification_login.visibility = View.VISIBLE
        }

        /**
         * 验证码登录
         */
        tv_verification_login.setOnClickListener {
            ll_pwd_layout.visibility = View.GONE
            tv_pwd_login.visibility = View.VISIBLE
            tv_verification_login.visibility = View.GONE
        }

        /**
         * 输入密码
         */
        et_pwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.length >= 1) {
                    ll_pwd_layout.background = resources.getDrawable(R.drawable.phone_login_et_bg)
                    if(flag){
                        tv_pwd.background = resources.getDrawable(R.mipmap.view_pwd)
                    }else{
                        tv_pwd.background = resources.getDrawable(R.mipmap.pwd_input)
                    }
                }else{
                    ll_pwd_layout.background = resources.getDrawable(R.drawable.phone_login_bg)
                    tv_pwd.background = resources.getDrawable(R.mipmap.pwd_no_input)
                }

            }
        })

        /**
         * 查看密码
         */
        tv_pwd.setOnClickListener {
            if(StringUtils.object2String(et_pwd.text).length >= 1){
                if(flag){
                    flag = false
                    tv_pwd.background = resources.getDrawable(R.mipmap.pwd_input)
                    et_pwd.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
                }else{
                    flag = true
                    tv_pwd.background = resources.getDrawable(R.mipmap.view_pwd)
                    et_pwd.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT
                }
            }
        }
    }

    /**
     * 发送短信
     */
    override fun onSendVerificationCodeSuccess(publicResultBean: PublicResultBean?) {
        if(publicResultBean!!.status == Constant.OK_RESULT){
            var intent = Intent(this, VerifyPhoneLoginActivity::class.java)
            intent.putExtra("phone", StringUtils.object2String(et_phone.text))
            startActivity(intent)
        }
        T.showShort(this,publicResultBean.msg)
    }

    override fun onSendVerificationCodeFailure(e: Throwable?) {
    }

    /**
     * 账号密码登陆
     */
    override fun onLoginPwdSuccess(loginBean: LoginBean?) {
        if(loginBean!!.status == Constant.OK_RESULT){
            var name: SharedPreferences = StackDinApplication.getAppContext().getSharedPreferences("name", MODE_PRIVATE)
            var edit = name.edit()
            edit.putString("member_id", StringUtils.object2String(loginBean.data.member_info.id))
            edit.putString("token", StringUtils.object2String(loginBean.data.token))
            edit.putString("uuid", StringUtils.object2String(loginBean.data.member_info.uuid))
            edit.commit()

            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        T.showShort(this,loginBean.msg)
    }

    override fun onLoginPwdFailure(e: Throwable?) {
    }

    override fun onLoginCodeSuccess(loginBean: LoginBean?) {
    }

    override fun onLoginCodeFailure(e: Throwable?) {
    }

}