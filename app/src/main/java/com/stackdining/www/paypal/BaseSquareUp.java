package com.stackdining.www.paypal;

import android.app.Activity;
import sqip.CardEntry;

public class BaseSquareUp {

    /**
     * 添加卡
     */
    public static void AddCard(Activity activity,int requestCode){
        CardEntry.startCardEntryActivity(activity, true,
                requestCode);
    }
}
