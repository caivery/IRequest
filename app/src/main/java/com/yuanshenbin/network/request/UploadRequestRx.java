package com.yuanshenbin.network.request;


import com.yjp.dealer.basic.util.JsonUtils;
import com.yjp.dealer.basic.util.YJPLog;

import java.util.Map;

import io.reactivex.Observable;


/**
 * Created by Jacky on 2017/2/4.
 */

public class UploadRequestRx extends BaseRequest<UploadRequestRx> {
    public <T> UploadRequestRx(String url, T params) {
        this.url = url;
        this.mapParams = (Map<Object, Object>) params;
        YJPLog.json(JsonUtils.string(this.mapParams));
    }
    public <T> Observable<T> execute(Class<T> classOfT) {
        return RequestManager.upload(this, classOfT);
    }

}
