package com.hll.android.loadmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;

/**
 * Created by lin on 2016/7/8.
 */
public abstract class LoadMoreContainerBase extends LinearLayout implements LoadMoreContainer{


    private boolean mAutoLoadMore = true;
    private boolean mLoading = false;
    private boolean mHasMore = false;


    private boolean mShowLoadingForFirstPage = false;

    private boolean mEmptyData = true;

    private AbsListView mAbsListView;   // content view
    private View mLoadMoreView;    // footer view

    private LoadMoreHandler mLoadMoreHandler;
    private LoadMoreUIHandler mLoadMoreUIHandler;


    public LoadMoreContainerBase(Context context) {
        super(context);
    }

    public LoadMoreContainerBase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadMoreContainerBase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void useLoadMoreDefaultView(){
        LoadMoreDefaultView view = new LoadMoreDefaultView(getContext());
        view.setVisibility(GONE);
        setLoadMoreView(view);
        setLoadMoreUIHandler(view);
    }


    /**
     * 加载xml，初始化
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mAbsListView = getAbsListView();
        init();
    }

    private void init(){

        mAbsListView.setOnScrollListener(new AbsListView.OnScrollListener() {

            private boolean isEnd;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    if (isEnd) {
                        onReachBottom();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount >= totalItemCount - 1) {
                    isEnd = true;
                } else {
                    isEnd = false;
                }
            }
        });
    }

    /**
     * called when reached bottom
     */
    private void onReachBottom(){
        if(mAutoLoadMore){
            performLoadMore();
        }else{
            if(mHasMore){
                mLoadMoreUIHandler.onWaiting(this);
            }
        }
    }


    /**
     * try to load more
     */
    private void performLoadMore(){

        if(mLoading){
            return ;
        }

        if(!mHasMore){
            return ;
        }

        if(mLoadMoreUIHandler != null){
            mLoadMoreUIHandler.onLoading(this);
        }

        if(mLoadMoreHandler != null){
            mLoadMoreHandler.onLoadMore(this);
        }

    }



    @Override
    public void setLoadMoreHanlder(LoadMoreHandler handler) {
        this.mLoadMoreHandler = handler;
    }

    @Override
    public void setLoadMoreUIHandler(LoadMoreUIHandler handler) {
        this.mLoadMoreUIHandler = handler;
    }

    @Override
    public void setAutoLoadMore(boolean autoLoadMore) {
        this.mAutoLoadMore = autoLoadMore;
    }

    @Override
    public void loadMoreFinished(boolean emptyData, boolean hasMore) {
        this.mLoading = false;
        this.mEmptyData = emptyData;
        this.mHasMore = hasMore;

        if(this.mLoadMoreUIHandler != null){
            this.mLoadMoreUIHandler.onLoadFinished(this, this.mEmptyData, this.mHasMore);
        }
    }

    @Override
    public void loadMoreFailed(){
        this.mLoading = false;

        if(this.mLoadMoreUIHandler != null){
            this.mLoadMoreUIHandler.onLoadFailed(this);
        }
    }

    @Override
    public void setLoadMoreView(View view) {

        // remove previous
        if(view != null && mLoadMoreView != view){
            removeLoadMoreView(mLoadMoreView);
        }

        // add current
        mLoadMoreView = view;
        addLoadMoreView(mLoadMoreView);

        mLoadMoreView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                performLoadMore();
            }
        });
    }

    @Override
    public void setShowLoadingForFirstPage(boolean showLoading) {
        mShowLoadingForFirstPage = showLoading;
    }

    protected abstract void addLoadMoreView(View view);
    protected abstract void removeLoadMoreView(View view);
    protected abstract AbsListView getAbsListView();
}
