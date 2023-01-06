package com.stackdining.www.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;


/**
 * Created by
 * Email:
 * Describe ：倒计时按钮
 */
public class CommonBtn {
    public static final String NUMBERCHAR = "0123456789";
    private static int charLen = NUMBERCHAR.length();

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;

        return (int) ((pxValue - 0.5f) / scale);

    }

    /**
     * @return :
     * @author :
     * @params :
     * @remark : 自定义时间，样式
     */
    public static void timingCustomText(final TextView btn, int time, String text, String title) {
        btn.setEnabled(false);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                int time = (Integer) msg.obj;
                if (btn != null) {
                    btn.setEnabled(false);
                    if (time > 0) {
                        btn.setEnabled(false);
                        btn.setText(time);
                    } else {
                        btn.setEnabled(true);
                        btn.setText(title);
                    }
                }
                super.handleMessage(msg);
            }

        };
        new Thread(new Runnable() {
            private int num = time;
            private Message msg;

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num--;
                    msg = new Message();
                    msg.obj = num;
                    handler.sendMessage(msg);
                    if (num <= 0) {
                        break;
                    }
                }

            }
        }).start();
    }

}
