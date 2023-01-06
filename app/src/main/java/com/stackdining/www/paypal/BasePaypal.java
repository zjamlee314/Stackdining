package com.stackdining.www.paypal;

import com.paypal.checkout.PayPalCheckout;
import com.paypal.checkout.config.CheckoutConfig;
import com.paypal.checkout.config.Environment;
import com.paypal.checkout.createorder.CurrencyCode;
import com.paypal.checkout.createorder.UserAction;
import com.stackdining.www.app.StackDinApplication;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * paypal
 */
public class BasePaypal {

    /**
     * 初始化paypal
     */
    public void inintPaypal(String clientId,String environment){
        PayPalCheckout.setConfig(new CheckoutConfig(
                StackDinApplication.getAppContext(),
                clientId,
                environment.equals("LIVE") ? Environment.LIVE : Environment.SANDBOX,
                CurrencyCode.USD,
                UserAction.PAY_NOW
        ));
    }

    /**
     * 支付
     */
    public void pay(String orderID){
        PayPalCheckout.registerCallbacks(
                approval -> {
                    //dialog.dismiss();
                    Map<String,Object> map = new HashMap<>();
                    map.put("orderID",orderID);
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("response",map);
                        jsonObject.put("type", "Success");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //callback.invoke(jsonObject);
                },
                () -> {
                    //dialog.dismiss();
                    JSONObject data = new JSONObject();
                    try {
                        data.put("type", "Cancel");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //callback.invoke(data);
                },
                errorInfo -> {
                    //dialog.dismiss();
                    JSONObject data = new JSONObject();
                    try {
                        data.put("type", "Error");
                        data.put("code", "0");
                        data.put("msg", errorInfo.getError().getMessage());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //callback.invoke(data);
                }
        );

        PayPalCheckout.startCheckout(
                createOrderActions -> {
                    createOrderActions.set(orderID);
                }
        );
    }
}
