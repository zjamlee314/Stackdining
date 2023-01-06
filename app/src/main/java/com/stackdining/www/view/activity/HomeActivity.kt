package com.stackdining.www.view.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.stackdining.www.R
import com.stackdining.www.utils.AppManager
import com.stackdining.www.utils.StatusBarUtil
import com.stackdining.www.view.fragment.HomeFragment
import com.stackdining.www.view.fragment.MemberFragment
import com.stackdining.www.view.fragment.MyFragment
import com.stackdining.www.view.fragment.OrderFragment
import com.stackdining.www.widget.BottomNavigationBar
import kotlinx.android.synthetic.main.activity_home.*

/**
 *  Created by Evan
 *  on 2022/2/15
 */
class HomeActivity : FragmentActivity(){

    private val manager: FragmentManager = supportFragmentManager
    lateinit var transaction: FragmentTransaction
    var homeFragment: HomeFragment? = null
    var memberFragment: MemberFragment? = null
    var orderFragment: OrderFragment? = null
    var myFragment: MyFragment? = null

    //fragment tag参数标识
    var tab1 = "1"
    var tab2 = "2"
    var tab3 = "3"
    var tab4 = "4"
    var user_id = "1"

    override fun onCreate(savedInstanceState: Bundle?) {
        //8.0透明主题与竖屏崩溃问题
        if (android.os.Build.VERSION.SDK_INT != Build.VERSION_CODES.O) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        super.onCreate(savedInstanceState)
        AppManager.getAppManager().addActivity(this)
        setContentView(attachLayoutRes())
        initViews()

    }

    fun attachLayoutRes(): Int {
        return R.layout.activity_home
    }

    fun initViews() {

        bottomNavigationBar.setOnListener(object : BottomNavigationBar.onBottomNavClickListener {
            override fun onIconClick(viewId: Int, i: Int) {
                when (i) {
                    0 -> {
                        showFragment(tab1)
                    }
                    1 -> {
                        showFragment(tab2)
                    }
                    2 -> {
                        if("".equals(user_id)){
                            var intent = Intent(this@HomeActivity, PhoneLoginActivity::class.java)
                            startActivity(intent)
                        }else{
                            showFragment(tab3)
                        }

                    }
                    3 -> {
                        if("".equals(user_id)){
                            var intent = Intent(this@HomeActivity, PhoneLoginActivity::class.java)
                            startActivity(intent)
                        }else{
                            showFragment(tab4)
                        }
                    }
                }
            }

            override fun onCenterIconClick() {}
        })
        transaction = manager.beginTransaction()
        //默认首页
        showFragment(tab1)
    }

    fun showFragment(tag: String) {
        var ft = manager.beginTransaction()
        hideFragment(ft)
        when (tag) {
            tab1 -> {
                //navUtils.showStateColor(0)
                //状态栏字体变为白色
                StatusBarUtil.setStatusBarDarkTheme(this@HomeActivity, true)
                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                    homeFragment?.let { ft.add(R.id.content, it, tab1) }
                } else {
                    homeFragment =
                        supportFragmentManager.findFragmentByTag(tab1) as HomeFragment?
                    homeFragment?.let { ft.show(it) }
                }

            }
            tab2 -> {
                //navUtils.showStateColor(1)
                //状态栏字体变为深色
                StatusBarUtil.setStatusBarDarkTheme(this@HomeActivity, true)
                if (memberFragment == null) {
                    memberFragment = MemberFragment()
                    memberFragment?.let { ft.add(R.id.content, it, tab2) }
                } else {
                    memberFragment =
                        supportFragmentManager.findFragmentByTag(tab2) as MemberFragment?
                    memberFragment?.let { ft.show(it) }
                }
            }
            tab3 -> {
                //navUtils.showStateColor(2)
                //状态栏字体变为深色
                StatusBarUtil.setStatusBarDarkTheme(this@HomeActivity, true)
                if (orderFragment == null) {
                    orderFragment = OrderFragment()
                    orderFragment?.let { ft.add(R.id.content, it, tab3) }
                } else {
                    orderFragment = supportFragmentManager.findFragmentByTag(tab3) as OrderFragment?
                    orderFragment?.let { ft.show(it) }
                }
            }
            tab4 -> {
                //navUtils.showStateColor(3)
                //状态栏字体变为白色
                StatusBarUtil.setStatusBarDarkTheme(this@HomeActivity, true)
                if (myFragment == null) {
                    myFragment = MyFragment()
                    var bundle = Bundle()
                    myFragment!!.arguments = bundle
                    myFragment?.let { ft.add(R.id.content, it, tab4) }
                } else {
                    myFragment = supportFragmentManager.findFragmentByTag(tab4) as MyFragment?
                    myFragment?.let { ft.show(it) }
                }
            }
        }
        ft.commit()

    }

    fun hideFragment(ft: FragmentTransaction) {
        try {
            //如果不为空，就先隐藏起来
            if (homeFragment != null) {
                homeFragment = supportFragmentManager.findFragmentByTag(tab1) as HomeFragment?
                ft.hide(homeFragment!!)
            }
            if (memberFragment != null) {
                memberFragment = supportFragmentManager.findFragmentByTag(tab2) as MemberFragment?
                ft.hide(memberFragment!!)
            }
            if (orderFragment != null) {
                orderFragment = supportFragmentManager.findFragmentByTag(tab3) as OrderFragment?
                ft.hide(orderFragment!!)
            }
            if (myFragment != null) {
                myFragment = supportFragmentManager.findFragmentByTag(tab4) as MyFragment?
                ft.hide(myFragment!!)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}