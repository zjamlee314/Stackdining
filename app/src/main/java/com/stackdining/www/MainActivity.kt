package com.stackdining.www

import android.content.Intent
import android.widget.Toast
import com.stackdining.www.base.BaseActivity
import com.stackdining.www.presenter.LoginPresenter
import sqip.*
import sqip.CardEntry.handleActivityResult

class MainActivity : BaseActivity<LoginPresenter>() {

    override fun providePresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        handleActivityResult(data,
            object : Callback<CardEntryActivityResult> {
                override fun onResult(result: CardEntryActivityResult) {
                    if (result.isSuccess()) {
                        var cardResult: CardDetails = result.getSuccessValue()
                        var (brand, lastFourDigits, expirationMonth, expirationYear, postalCode, type, prepaidType) = cardResult.card
                        var nonce = cardResult.nonce
                    } else if (result.isCanceled()) {
                        Toast.makeText(
                            this@MainActivity,
                            "Canceled",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
    }

}