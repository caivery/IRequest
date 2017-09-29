package com.yuanshenbin.state;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

/**
 * author : yuanshenbin
 * time   : 2017/9/26
 * desc   :
 */

public abstract class StateAbstract {

    @LayoutRes
    public abstract int onCreateView();

    private String msg;

    public void onViewCreated(Context context, LinearLayout root) {
        if (root != null && root.getVisibility() == View.GONE) {
            root.setVisibility(View.VISIBLE);
        }
        root.removeAllViews();
        ViewStub viewStub = new ViewStub(context);
        viewStub.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        viewStub.setLayoutResource(onCreateView());
        root.addView(viewStub);
        viewStub.inflate();

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

} 
