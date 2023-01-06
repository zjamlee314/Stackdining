package com.stackdining.www.view.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.KeyEvent
import android.view.View
import com.stackdining.www.R
import com.stackdining.www.app.Constant
import com.stackdining.www.app.StackDinApplication
import com.stackdining.www.base.BaseActivity
import com.stackdining.www.contract.LoginContract
import com.stackdining.www.model.bean.LoginBean
import com.stackdining.www.model.bean.PublicResultBean
import com.stackdining.www.presenter.LoginPresenter
import com.stackdining.www.show.T
import com.stackdining.www.utils.ApplicationUtils
import com.stackdining.www.utils.StringUtils
import com.stackdining.www.utils.uuid.DeviceUuidFactory
import kotlinx.android.synthetic.main.activity_verify_phone_login.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class VerifyPhoneLoginActivity : BaseActivity<LoginPresenter>(),LoginContract.IView{

    var phone = ""
    lateinit var uuidFactory: DeviceUuidFactory

    override fun providePresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_verify_phone_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inintDatas()
        inintEvents()
    }

    /**
     * 初始化数据
     */
    fun inintDatas(){
        uuidFactory = DeviceUuidFactory(this)
        phone = StringUtils.object2String(intent.getStringExtra("phone"))
        tv_phone.text = resources.getString(R.string.one) + " " + phone
        var mSpannableString = SpannableString(getString(R.string.Resendcode))
        mSpannableString.setSpan(ForegroundColorSpan(resources.getColor(R.color.color_eab54a)),15,17, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        tv_verify_num.text = mSpannableString

       //CommonBtn.timingCustomText(tv_verify_num, 60, mSpannableString.toString(),"获取验证码")
    }

    /**
     * 初始化事件
     */
    fun inintEvents(){

        /**
         * 返回
         */
        tv_back.setOnClickListener {
            finish()
        }

        /**
         * 监听焦点
         */
        et_1.onFocusChangeListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(view: View?, b: Boolean) {
                if (b) {
                    ll_1.background = resources.getDrawable(R.drawable.phone_login_et_bg)
                } else {
                    ll_1.background = resources.getDrawable(R.drawable.phone_login_bg)
                }
            }
        }

        et_2.onFocusChangeListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(view: View?, b: Boolean) {
                if (b) {
                    ll_2.background = resources.getDrawable(R.drawable.phone_login_et_bg)
                } else {
                    ll_2.background = resources.getDrawable(R.drawable.phone_login_bg)
                }
            }
        }

        et_3.onFocusChangeListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(view: View?, b: Boolean) {
                if (b) {
                    ll_3.background = resources.getDrawable(R.drawable.phone_login_et_bg)
                } else {
                    ll_3.background = resources.getDrawable(R.drawable.phone_login_bg)
                }
            }
        }

        et_4.onFocusChangeListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(view: View?, b: Boolean) {
                if (b) {
                    ll_4.background = resources.getDrawable(R.drawable.phone_login_et_bg)
                } else {
                    ll_4.background = resources.getDrawable(R.drawable.phone_login_bg)
                }
            }
        }


        /**
         * 监听输入
         */
        et_1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!StringUtils.object2String(et_1.text).equals("")) {
                    et_2.isEnabled = true
                    et_2.isFocusableInTouchMode = true
                    et_2.requestFocus()
                    et_2.isCursorVisible = true

                    et_1.isEnabled = true
                    et_1.isCursorVisible = false
                    et_1.isFocusableInTouchMode = false

                }
            }
        })

        et_2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!StringUtils.object2String(et_2.text).equals("")) {
                    et_3.isEnabled = true
                    et_3.isFocusableInTouchMode = true
                    et_3.requestFocus()
                    et_3.isCursorVisible = true

                    et_2.isEnabled = true
                    et_2.isCursorVisible = false
                    et_2.isFocusableInTouchMode = false
                }
            }
        })

        et_3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!StringUtils.object2String(et_3.text).equals("")) {
                    et_4.isEnabled = true
                    et_4.isFocusableInTouchMode = true
                    et_4.requestFocus()
                    et_4.isCursorVisible = true

                    et_3.isEnabled = true
                    et_3.isCursorVisible = false
                    et_3.isFocusableInTouchMode = false
                }
            }
        })

        et_4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {

                if (!StringUtils.object2String(et_4.text).equals("")) {
//                    et_4.isEnabled = true
//                    et_4.isFocusableInTouchMode = true
//                    et_4.requestFocus()
//                    et_4.isCursorVisible = true
//                    et_3.isEnabled = true
//                    et_3.isCursorVisible = false
//                    et_3.isFocusableInTouchMode = false
                    /**
                     * 登录
                     */
                    var hashMap = HashMap<String,Any>()
                    hashMap["phoneno"] = phone
                    hashMap["country_code"] = "1"
                    hashMap["uuid"] = StringUtils.object2String(uuidFactory.uuid)
                    hashMap["verify_code"] = StringUtils.object2String(et_1.text) + StringUtils.object2String(et_2.text) +
                            StringUtils.object2String(et_3.text) + StringUtils.object2String(et_4.text)
                    mPresenter.loginCode(hashMap)

                }
            }
        })

        /**
         * 监听删除
         */
        et_4.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action === KeyEvent.ACTION_UP && event.keyCode === KeyEvent.KEYCODE_DEL) {
                if (StringUtils.object2String(et_4.text).trim().equals("")) {
                    et_3.setText("")
                    et_3.isEnabled = true
                    et_3.isFocusableInTouchMode = true
                    et_3.requestFocus()
                    et_3.isCursorVisible = true

                    et_4.isEnabled = true
                    et_4.isCursorVisible = false
                    et_4.isFocusableInTouchMode = false
                } else {
                    et_4.setText("")
                    et_4.isEnabled = true
                    et_4.isCursorVisible = true
                    et_4.isFocusableInTouchMode = true
                    et_4.requestFocus()
                }
            }
            true
        })

        et_3.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action === KeyEvent.ACTION_UP && event.keyCode === KeyEvent.KEYCODE_DEL) {
                if (StringUtils.object2String(et_4.text).trim().equals("")) {
                    et_2.setText("")
                    et_2.isEnabled = true
                    et_2.isFocusableInTouchMode = true
                    et_2.requestFocus()
                    et_2.isCursorVisible = true

                    et_3.isEnabled = true
                    et_3.isCursorVisible = false
                    et_3.isFocusableInTouchMode = false
                } else {
                    et_3.setText("")
                    et_3.isEnabled = true
                    et_3.isCursorVisible = true
                    et_3.isFocusableInTouchMode = true
                    et_3.requestFocus()
                }
            }
            true
        })

        et_2.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action === KeyEvent.ACTION_UP && event.keyCode === KeyEvent.KEYCODE_DEL) {
                if (StringUtils.object2String(et_4.text).trim().equals("")) {
                    et_1.setText("")
                    et_1.isEnabled = true
                    et_1.isFocusableInTouchMode = true
                    et_1.requestFocus()
                    et_1.isCursorVisible = true

                    et_2.isEnabled = true
                    et_2.isCursorVisible = false
                    et_2.isFocusableInTouchMode = false
                } else {
                    et_2.setText("")
                    et_2.isEnabled = true
                    et_2.isCursorVisible = true
                    et_2.isFocusableInTouchMode = true
                    et_2.requestFocus()
                }
            }
            true
        })

    }

    /**
     * 有五种方式取得设备的唯一标识。它们中的一些可能会返回null，或者由于硬件缺失、权限问题等获取失败。
     * 但你总能获得至少一个能用。所以，最好的方法就是通过拼接，或者拼接后的计算出的MD5值来产生一个结果。
     */
    fun getUniqueID(context: Context?): String? {
        val m_szLongID: String =
            ApplicationUtils.getPesudoUniqueID() + ApplicationUtils.getWLANMACAddress(context) + ApplicationUtils.getBTMACAddress()
        // compute md5
        var m: MessageDigest? = null
        try {
            m = MessageDigest.getInstance("MD5")
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        m!!.update(m_szLongID.toByteArray(), 0, m_szLongID.length)
        // get md5 bytes
        val p_md5Data = m.digest()
        // create a hex string
        var m_szUniqueID = String()
        for (i in p_md5Data.indices) {
            val b = 0xFF and p_md5Data[i].toInt()
            // if it is a single digit, make sure it have 0 in front (proper padding)
            if (b <= 0xF) {
                m_szUniqueID += "0"
            }
            // add number to string
            m_szUniqueID += Integer.toHexString(b)
        } // hex string to uppercase
        m_szUniqueID = m_szUniqueID.toUpperCase()
        return m_szUniqueID
    }

    override fun onSendVerificationCodeSuccess(publicResultBean: PublicResultBean?) {
    }

    override fun onSendVerificationCodeFailure(e: Throwable?) {
    }

    /**
     * 登陆
     */
    override fun onLoginCodeSuccess(loginBean: LoginBean?) {
        if(loginBean!!.status == Constant.OK_RESULT){
            var name: SharedPreferences = StackDinApplication.getAppContext().getSharedPreferences("name", MODE_PRIVATE)
            var edit = name.edit()
            edit.putString("member_id", StringUtils.object2String(loginBean.data.member_info.id))
            edit.putString("token", StringUtils.object2String(loginBean.data.token))
            edit.putString("uuid", StringUtils.object2String(loginBean.data.member_info.uuid))
            edit.commit()

            var intent = Intent(this@VerifyPhoneLoginActivity,HomeActivity::class.java)
            startActivity(intent)
        }
        T.showShort(this,loginBean.msg)
    }

    override fun onLoginCodeFailure(e: Throwable?) {
    }

    override fun onLoginPwdSuccess(loginBean: LoginBean?) {
    }

    override fun onLoginPwdFailure(e: Throwable?) {
    }
}