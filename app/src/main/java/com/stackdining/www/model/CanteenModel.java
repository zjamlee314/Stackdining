package com.stackdining.www.model;

import com.stackdining.www.contract.CanteenContract;
import com.stackdining.www.model.bean.CanteenDetailsBean;
import com.stackdining.www.model.bean.DishesListBean;
import com.stackdining.www.model.bean.NewDishesListBean;
import com.stackdining.www.model.bean.PublicResultBean;
import com.stackdining.www.utils.CommonObserver;
import com.stackdining.www.utils.CommonSchedulers;
import com.stackdining.www.utils.RetrofitManager;

import java.util.Map;

public class CanteenModel implements CanteenContract.IModel {

    @Override
    public void about(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .about(paramsMap)
                .compose(CommonSchedulers.<CanteenDetailsBean>io2main())
                .subscribe(new CommonObserver<CanteenDetailsBean>() {
                    @Override
                    public void onNext(CanteenDetailsBean canteenDetailsBean) {
                        callback.onAboutSuccess(canteenDetailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onAboutFailure(e);
                    }
                });
    }

    @Override
    public void dishes_list(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .dishes_list(paramsMap)
                .compose(CommonSchedulers.<DishesListBean>io2main())
                .subscribe(new CommonObserver<DishesListBean>() {
                    @Override
                    public void onNext(DishesListBean dishesListBean) {
                        callback.onDishesListSuccess(dishesListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onDishesListFailure(e);
                    }
                });
    }

    @Override
    public void save(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .save(paramsMap)
                .compose(CommonSchedulers.<PublicResultBean>io2main())
                .subscribe(new CommonObserver<PublicResultBean>() {
                    @Override
                    public void onNext(PublicResultBean publicResultBean) {
                        callback.onSaveSuccess(publicResultBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onSaveFailure(e);
                    }
                });
    }

    @Override
    public void new_dishes_list(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .new_dishes_list(paramsMap)
                .compose(CommonSchedulers.<NewDishesListBean>io2main())
                .subscribe(new CommonObserver<NewDishesListBean>() {
                    @Override
                    public void onNext(NewDishesListBean newDishesListBean) {
                        callback.onNewDishesListSuccess(newDishesListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onNewDishesListFailure(e);
                    }
                });
    }
}
