package com.stackdining.www.model;

import com.stackdining.www.contract.PersonalContract;
import com.stackdining.www.model.bean.PersonalDataBean;
import com.stackdining.www.utils.CommonObserver;
import com.stackdining.www.utils.CommonSchedulers;
import com.stackdining.www.utils.RetrofitManager;

import java.util.Map;

public class PersonalModel implements PersonalContract.IModel {

    @Override
    public void personalInfo(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .personal_data(paramsMap)
                .compose(CommonSchedulers.<PersonalDataBean>io2main())
                .subscribe(new CommonObserver<PersonalDataBean>() {
                    @Override
                    public void onNext(PersonalDataBean personalDataBean) {
                        callback.onPersonalInfoSuccess(personalDataBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onPersonalInfoFailure(e);
                    }
                });
    }
}
