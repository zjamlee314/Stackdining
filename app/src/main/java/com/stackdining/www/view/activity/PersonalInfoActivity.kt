package com.stackdining.www.view.activity

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.stackdining.www.R
import com.stackdining.www.app.Constant
import com.stackdining.www.base.BaseActivity
import com.stackdining.www.contract.PersonalContract
import com.stackdining.www.model.bean.PersonalDataBean
import com.stackdining.www.presenter.PersonalPresenter
import kotlinx.android.synthetic.main.activity_personal_info.*
import kotlinx.android.synthetic.main.activity_public_title.*

class PersonalInfoActivity : BaseActivity<PersonalPresenter>() , PersonalContract.IView{

    override fun providePresenter(): PersonalPresenter {
        return PersonalPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_personal_info
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

        tv_title.text = this.getString(R.string.Profile)

        var hashMap = HashMap<String,Any>()
        mPresenter!!.personalInfo(hashMap)
    }

    /**
     * 初始化事件
     */
    fun inintEvents(){
        finish_back.setOnClickListener {
            finish()
        }
    }

    /**
     * 个人信息
     */
    override fun onPersonalInfoSuccess(personalDataBean: PersonalDataBean?) {
        if(personalDataBean!!.status == Constant.OK_RESULT){
            tv_name.text = personalDataBean!!.data.nickname
            tv_birthday.text = personalDataBean!!.data.birthday
            //tv_gender.text = personalDataBean!!.data.gender
            tv_phone.text = personalDataBean!!.data.phone
            Glide.with(this!!)
                .load(personalDataBean!!.data.avatar)
                .placeholder(R.mipmap.default_avatar)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(iv_img)
        }
    }

    override fun onPersonalInfoFailure(e: Throwable?) {
    }

}