package com.yuanshenbin;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yuanshenbin.base.BaseActivity;
import com.yuanshenbin.state.ErrorState;
import com.yuanshenbin.state.NetworkState;
import com.yuanshenbin.state.OnRetryListener;
import com.yuanshenbin.state.StateLayoutManager;
import com.yuanshenbin.state.TimeOutState;

import butterknife.BindView;

/**
 * author : yuanshenbin
 * time   : 2017/9/26
 * desc   :
 */

public class StateActivity extends BaseActivity {
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_state;
    }

    @Override
    protected void initDatas() {

        final StateLayoutManager layoutManager = new StateLayoutManager.Builder(this, findViewById(R.id.ll_state))
                .errorStateView(new ErrorState())
                .timeOutStateView(new TimeOutState())
                .networkStateView(new NetworkState(new OnRetryListener() {
                    @Override
                    public void onRetry() {

                        Toast.makeText(mContext, "重试在", Toast.LENGTH_SHORT).show();  
                     }
                }))
                .build();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutManager.showError();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutManager.showNetwork();
            }
        });


    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initAdapter() {

    }

}
