package com.stackdining.www.show;

import android.util.Log;
import com.stackdining.www.utils.StringUtils;


/**
 * Log统一管理类
 *
 * @author way
 */
public class L {

    private L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    // 是否需要打印bug，可以在application的onCreate函数里面初始化
    public static boolean isDebug = true; //BuildConfig.DEBUG;
    private static final String TAG = "PAY++";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug) {
            Log.i(TAG, StringUtils.object2String(msg));
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, StringUtils.object2String(msg));
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            Log.e(TAG, StringUtils.object2String(msg));
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, StringUtils.object2String(msg));
        }
    }

    public static void v(String msg) {
        if (isDebug) {
            Log.v(TAG, StringUtils.object2String(msg));
        }
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, StringUtils.object2String(msg));
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, StringUtils.object2String(msg));
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, StringUtils.object2String(msg));
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, StringUtils.object2String(msg));
        }
    }

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.v(tag, StringUtils.object2String(msg));
        }
    }

    public static void print(String msg) {
        if (isDebug) {
            System.out.println(StringUtils.object2String(msg));
        }
    }

    public static void print(Boolean msg) {
        if (isDebug) {
            System.out.println(StringUtils.object2String(msg));
        }
    }

    public static void print(int msg) {
        if (isDebug) {
            System.out.println(StringUtils.object2String(msg));
        }
    }
}