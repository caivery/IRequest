package com.yuanshenbin.state;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * author : yuanshenbin
 * time   : 2017/9/26
 * desc   :
 */

public class StateLayoutManager {

    private Context context;
    private ErrorState errorState;
    private TimeOutState timeOutState;
    private EmptyState emptyState;
    private LoadingState loadingState;
    private NetworkState networkState;
    private LinearLayout root;

    public StateLayoutManager(Builder builder) {
        this.context = builder.context;
        this.errorState = builder.errorState;
        this.timeOutState = builder.timeOutState;
        this.emptyState = builder.emptyState;
        this.loadingState = builder.loadingState;
        this.networkState = builder.networkState;
        this.root = (LinearLayout) builder.root;

    }

    public void showError() {
        errorState.onViewCreated(context, root);

    }

    public void showTimeOut() {
        timeOutState.onViewCreated(context, root);
    }

    public void showNetwork() {
        networkState.setMsg("没有网络");
        networkState.onViewCreated(context, root);

    }

    public void showLoading() {
        loadingState.onViewCreated(context, root);
    }

    public void showEmpty() {
        emptyState.onViewCreated(context, root);
    }

    public void showContent() {
        root.setVisibility(View.GONE);
    }

    public static final class Builder {
        private Context context;

        private View root;

        private ErrorState errorState;
        private TimeOutState timeOutState;
        private EmptyState emptyState;
        private LoadingState loadingState;
        private NetworkState networkState;

        public Builder(Context context, View root) {
            this.context = context;
            this.root = root;
        }

        public Builder errorStateView(ErrorState errorState) {
            this.errorState = errorState;
            return this;
        }

        public Builder timeOutStateView(TimeOutState timeOutState) {
            this.timeOutState = timeOutState;
            return this;
        }

        public Builder emptyStateView(EmptyState emptyState) {
            this.emptyState = emptyState;
            return this;
        }

        public Builder loadingStateView(LoadingState loadingState) {
            this.loadingState = loadingState;
            return this;
        }

        public Builder networkStateView(NetworkState networkState) {
            this.networkState = networkState;
            return this;
        }

        public StateLayoutManager build() {
            return new StateLayoutManager(this);
        }
    }

}
