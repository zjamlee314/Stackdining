package com.stackdining.www.show;

import android.content.Context;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.stackdining.www.R;
import com.stackdining.www.utils.StringUtils;


/**
 * Toast统一管理类
 */
public class T {

    private T() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;
    public static boolean isShowLOG = true;

    /**
     * @return :
     * @author :
     * @params :
     * @remark : toast自定义
     */
    private static void toastUI(Context context, String msg, int duration) {
        try {
            Toast toast = new Toast(context);
            LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflate.inflate(R.layout.toast_text, null);
            TextView tv = (TextView) v.findViewById(R.id.tv_text);
            tv.setText(msg);
            toast.setView(v);
            toast.setGravity(Gravity.CENTER, 0, 70);
            toast.setDuration(duration);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
    }

    /**
     * @return :
     * @author :
     * @params :
     * @remark : toast自定义底部提示
     */
    private static void toastBottomUI(Context context, String msg, int duration) {
        try {
            Toast toast = new Toast(context);
            LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflate.inflate(R.layout.toast_text, null);
            TextView tv = (TextView) v.findViewById(R.id.tv_text);
            tv.setText(msg);
            toast.setView(v);
            toast.setGravity(Gravity.BOTTOM, 0, 200);
            toast.setDuration(duration);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
    }


    /**
     * 子线程提示器
     */
    public static void showToast(final String toast, final Context context) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }).start();
    }

    /**
     * 短时间显示Toast日志
     *
     * @param context
     * @param message
     */
    public static void showShortLog(Context context, CharSequence message) {
        if (isShowLOG && null != context) {
            toastUI(context, "LOG==" + StringUtils.object2String(message),
                    Toast.LENGTH_SHORT);
        }
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, CharSequence message) {
        if (isShow && null != context) {
            toastUI(context, StringUtils.object2String(message), Toast.LENGTH_SHORT);
        }
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        if (isShow && null != context) {
            toastUI(context, StringUtils.object2String(message + ""),
                    Toast.LENGTH_SHORT);
        }
    }
    /**
     * 短时间显示Toast
     *显示底部
     * @param context
     * @param message
     */
    public static void showBottomShort(Context context, String message) {
        if (isShow && null != context) {
            toastBottomUI(context, StringUtils.object2String(message + ""),
                    Toast.LENGTH_SHORT);
        }
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        if (isShow && null != context) {
            toastUI(context, StringUtils.object2String(message), Toast.LENGTH_LONG);
        }
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        if (isShow && null != context) {
            toastUI(context, StringUtils.object2String(message + ""),
                    Toast.LENGTH_LONG);
        }
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow && null != context) {
            toastUI(context, StringUtils.object2String(message), duration);
        }
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration) {
        if (isShow && null != context) {
            toastUI(context, StringUtils.object2String(message + ""), duration);
        }
    }

    /**
     * 全局可显示的Toast
     *
     * @param msg
     */
    public static void showMessage(Context context, String msg) {
        toastUI(context, msg, Toast.LENGTH_SHORT);
    }
}