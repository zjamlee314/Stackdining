package com.stackdining.www.model;

import com.stackdining.www.contract.MainContract;
import com.stackdining.www.model.bean.HomeListBean;
import com.stackdining.www.utils.CommonObserver;
import com.stackdining.www.utils.CommonSchedulers;
import com.stackdining.www.utils.RetrofitManager;

import java.util.Map;

public class MainModel implements MainContract.IModel {

    @Override
    public void homeList(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .home_list(paramsMap)
                .compose(CommonSchedulers.<HomeListBean>io2main())
                .subscribe(new CommonObserver<HomeListBean>() {
                    @Override
                    public void onNext(HomeListBean homeListBean) {
                        callback.onHomeListSuccess(homeListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onHomeListFailure(e);
                    }
                });
    }
}
