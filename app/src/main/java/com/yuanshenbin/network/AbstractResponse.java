package com.yuanshenbin.network;


import android.widget.Toast;

import com.yuanshenbin.app.App;
import com.yuanshenbin.bean.ResponseModel;


/**
 * Created by Jacky on 2016/10/31.
 */
public abstract class AbstractResponse<T> {
    public abstract void onSuccess(T result);

    public void onFailed() {

        Toast.makeText(App.getInstance(), "网络不给力···", Toast.LENGTH_SHORT).show();
    }

    public void onResponseState(ResponseModel result) {

    }


    public void onEmptyData(){

    }


}
