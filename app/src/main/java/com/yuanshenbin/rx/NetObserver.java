package com.yuanshenbin.rx;


import android.widget.Toast;

import com.yuanshenbin.base.BasePresenter;
import com.yuanshenbin.bean.ResponseModel;
import com.yuanshenbin.network.ResponseEnum;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * author : yuanshenbin
 * time   : 2017/9/25
 * desc   :
 */
public abstract class NetObserver<T> implements Observer<T> {

    private BasePresenter mPresenter;
    
    private boolean isLoading =false;

    public void onResponseState(ResponseModel result) {

    }

    public NetObserver(BasePresenter presenter,boolean loading) {
        this.mPresenter = presenter;
        this.isLoading =loading;
        onResponseState(new ResponseModel(ResponseEnum.开始));
    }

    @Override
    public void onError(Throwable e) {
        //统一处理请求异常的情况
        if (e instanceof IOException) {
            Toast.makeText(mPresenter.mContext, "网络链接异常...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mPresenter.mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        onResponseState(new ResponseModel(ResponseEnum.失败,e));

    }

    @Override
    public void onComplete() {
        onResponseState(new ResponseModel(ResponseEnum.结束));
    }


    @Override
    public void onNext(@NonNull T t) {
        onResponseState(new ResponseModel(ResponseEnum.成功));
        _onNext(t);
    }

    public abstract void _onNext(@NonNull T t);

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (mPresenter != null)
            mPresenter.mDisposable.add(d);
    }
}
