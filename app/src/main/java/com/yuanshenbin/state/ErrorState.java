package com.yuanshenbin.state;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yuanshenbin.R;

/**
 * author : yuanshenbin
 * time   : 2017/9/26
 * desc   : 异常
 */

public class ErrorState extends StateAbstract {


    @Override
    public int onCreateView() {
        return R.layout.error;
    }

    @Override
    public void onViewCreated(final Context context, LinearLayout root) {
        super.onViewCreated(context, root); 
        final Button button = (Button) root.findViewById(R.id.btn_error);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
