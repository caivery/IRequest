package com.yuanshenbin.state;

import com.yuanshenbin.R;

/**
 * author : yuanshenbin
 * time   : 2017/9/26
 * desc   : 加载中
 */

public class LoadingState extends  StateAbstract {
    @Override
    public int onCreateView() {
        return R.layout.loading;
    }
}
