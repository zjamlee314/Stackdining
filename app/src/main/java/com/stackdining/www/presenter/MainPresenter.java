package com.stackdining.www.presenter;import com.stackdining.www.base.BasePresenter;import com.stackdining.www.contract.MainContract;import com.stackdining.www.model.MainModel;import com.stackdining.www.model.bean.HomeListBean;import java.util.Map;public class MainPresenter extends BasePresenter<MainContract.IView> implements MainContract.IPresenter {    private MainModel mainModel;    /**     * 1、在这个方法中初始化model     */    @Override    protected void initModel() {        mainModel = new MainModel();    }    @Override    public void homeList(Map<String, Object> paramsMap) {        //2、调用model中的的方法，设置回调监听        mainModel.homeList(paramsMap, new MainContract.IModel.IModelCallback() {            @Override            public void onHomeListSuccess(HomeListBean homeListBean) {                //3、必须先判断是否挂载、然后才可以使用getView方法                if (isViewAttached()) {                    if (homeListBean != null) {                        getView().onHomeListSuccess(homeListBean);                    }else {                        getView().onHomeListSuccess(homeListBean);                    }                }            }            @Override            public void onHomeListFailure(Throwable e) {                //4、失败回调                if (isViewAttached()) {                    getView().onHomeListFailure(e);                }            }        });    }}