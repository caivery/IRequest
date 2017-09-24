package com.yuanshenbin.network;

import com.yanzhenjie.nohttp.rest.Response;

/**
 * author : Jacky
 * e-mail : 87416471@qq.com
 * time   : 2017/09/24
 * desc   :
 */
public interface INetworkLinstener<T> {

    void  onResetTonker();

    void  onRecordLog(Response<T> response);



}
