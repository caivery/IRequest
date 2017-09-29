package com.yuanshenbin.state;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.yuanshenbin.R;

/**
 * author : yuanshenbin
 * time   : 2017/9/26
 * desc   : 没有网络
 */

public class NetworkState extends StateAbstract {


    private OnRetryListener listener;

    public NetworkState(@Nullable OnRetryListener l) {
        this.listener = l;
    }

    @Override
    public int onCreateView() {
        return R.layout.network;
    }

    @Override
    public void onViewCreated(Context context, LinearLayout root) {
        super.onViewCreated(context, root);
        Button title = (Button) root.findViewById(R.id.btn_network);
        title.setText(getMsg());
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onRetry();
                }
            }
        });

    }
} 
