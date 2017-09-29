package com.yuanshenbin.network.request;

import android.content.Context;

import com.yanzhenjie.nohttp.RequestMethod;
import com.yjp.dealer.basic.network.AbstractResponseUpload;
import com.yjp.dealer.basic.util.JsonUtils;
import com.yjp.dealer.basic.util.YJPLog;


/**
 * Created by Jacky on 2016/10/31.
 */
public class UploadRequest extends BaseRequest<UploadRequest> {
    public <T> UploadRequest(Context context, String url, T params) {
        this.url = url;
        this.context = context; 
        this.params = JsonUtils.string(params);
        YJPLog.json(this.params);
    }

    public <T> UploadRequest(Context context, String url) {
        this.url = url;
        this.context = context;
        this.isPostMap = true;
    }

    public <T> void execute(AbstractResponseUpload<T> l) {
        if (isPostMap) {
            this.params = JsonUtils.string(mapParams);
         YJPLog.json(this.params);
        }
        requestMethod(RequestMethod.POST);
        RequestManager.upload(this, l);
    }
}
