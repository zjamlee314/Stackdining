package com.stackdining.www.model;

import com.stackdining.www.contract.LoginContract;
import com.stackdining.www.model.bean.LoginBean;
import com.stackdining.www.model.bean.PublicResultBean;
import com.stackdining.www.utils.CommonObserver;
import com.stackdining.www.utils.CommonSchedulers;
import com.stackdining.www.utils.RetrofitManager;

import java.util.Map;

public class LoginModel implements LoginContract.IModel {


    @Override
    public void sendVerification(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .sendVerificationCode(paramsMap)
                .compose(CommonSchedulers.<PublicResultBean>io2main())
                .subscribe(new CommonObserver<PublicResultBean>() {
                    @Override
                    public void onNext(PublicResultBean publicResultBean) {
                        callback.onSendVerificationCodeSuccess(publicResultBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onSendVerificationCodeFailure(e);
                    }
                });
    }

    @Override
    public void loginCode(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .login_by_code(paramsMap)
                .compose(CommonSchedulers.<LoginBean>io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        callback.onLoginCodeSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoginCodeFailure(e);
                    }
                });
    }

    @Override
    public void loginPwd(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .login(paramsMap)
                .compose(CommonSchedulers.<LoginBean>io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        callback.onLoginPwdSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoginPwdFailure(e);
                    }
                });
    }
}
