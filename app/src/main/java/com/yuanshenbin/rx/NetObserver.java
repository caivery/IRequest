package com.yuanshenbin.rx;


import android.content.Context;
import android.widget.Toast;

import com.yuanshenbin.network.IDialog;
import com.yuanshenbin.util.ILogger;
import com.yuanshenbin.widget.DefaultDialog;

import java.io.IOException;

import io.reactivex.Observer;

/**
 * Created by yuanshenbin on 2017/7/6.
 */

public abstract class NetObserver<T> implements Observer<T> {

    private boolean isLoading;
    private Context mContext;
    private IDialog mDialog;

    public NetObserver(Context context, boolean loading) {
        isLoading = loading;
        this.mContext = context;
        showLoading();
    }
    @Override
    public void onError(Throwable e) {
        //统一处理请求异常的情况
        if (e instanceof IOException) {
            Toast.makeText(mContext, "网络链接异常...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        ILogger.e("rx", e);

    }

    @Override
    public void onComplete() {
        cancelLoading();
    }

    /**
     * 可在此处统一显示loading view
     */
    private void showLoading() {
        if (isLoading) {
            mDialog = new DefaultDialog();
            mDialog.init(mContext);
            mDialog.show();
        }
    }

    private void cancelLoading() {
        if (mDialog != null)
            mDialog.dismiss();
    }

}
