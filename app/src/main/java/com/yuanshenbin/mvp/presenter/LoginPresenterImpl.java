package com.yuanshenbin.mvp.presenter;


import com.yuanshenbin.base.BasePresenter;
import com.yuanshenbin.bean.PuBuLiuModel;
import com.yuanshenbin.mvp.contract.LoginContract;
import com.yuanshenbin.mvp.model.LoginModelImpl;
import com.yuanshenbin.rx.NetObserver;

import io.reactivex.annotations.NonNull;

/**
 * Created by Jacky on 2017/03/17
 */

public class LoginPresenterImpl extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private LoginContract.Model mModel;

    public LoginPresenterImpl() {

        mModel = new LoginModelImpl();

    }

    @Override
    public void getLogin1(String account, String pass) {
    }

    @Override
    public void getRegister2(String account, String pass) {
    }

    @Override
    public void getVerification3(String account, String pass) {
        append(mModel.getVerification3(account, pass), new NetObserver<PuBuLiuModel>(this, true) {
            @Override
            public void _onNext(@NonNull PuBuLiuModel puBuLiuModel) {
                
            }
        });
    }
}
