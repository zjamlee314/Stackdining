package com.stackdining.www.model.api;

import com.stackdining.www.model.bean.CanteenDetailsBean;
import com.stackdining.www.model.bean.DishesListBean;
import com.stackdining.www.model.bean.HomeListBean;
import com.stackdining.www.model.bean.LoginBean;
import com.stackdining.www.model.bean.NewDishesListBean;
import com.stackdining.www.model.bean.PersonalDataBean;
import com.stackdining.www.model.bean.PublicResultBean;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Retrofit默认只使用这一个IApi
 * <p>
 * <p>
 * 使用规范：
 * 一个http请求对应该接口中一个方法
 */
public interface IApi {

    //短信发送接口
    @GET("sendVerificationCode")
    Observable<PublicResultBean> sendVerificationCode(@QueryMap Map<String,Object>map);

    // 手机验证码登录
    @FormUrlEncoded
    @POST("login_by_code")
    Observable<LoginBean> login_by_code(@FieldMap Map<String,Object> map);

    // 手机验证码登录
    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean> login(@FieldMap Map<String,Object> map);

    // 首页列表
    @FormUrlEncoded
    @POST("/v5/restaurant/list")
    Observable<HomeListBean> home_list(@FieldMap Map<String,Object> map);

    //餐厅详情
    @GET("/restaurant_code/about")
    Observable<CanteenDetailsBean> about(@QueryMap Map<String,Object>map);

    //菜品列表
    @GET("/v4/restaurant_code/food/list")
    Observable<DishesListBean> dishes_list(@QueryMap Map<String,Object>map);

    //菜品列表
    @GET("/v5/food/list")
    Observable<NewDishesListBean> new_dishes_list(@QueryMap Map<String,Object>map);

    // 收藏/取消收藏店铺
    @FormUrlEncoded
    @POST("/v5/collect/save")
    Observable<PublicResultBean> save(@FieldMap Map<String,Object> map);

    //用户个人信息
    @GET("/personal_data")
    Observable<PersonalDataBean> personal_data(@QueryMap Map<String,Object>map);

}
