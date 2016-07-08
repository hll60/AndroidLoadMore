package com.hll.android.loadmore;

import android.view.View;

/**
 * Created by lin on 2016/7/8.
 */
public interface LoadMoreContainer {

    public void setLoadMoreHanlder(LoadMoreHandler handler);

    public void setLoadMoreUIHandler(LoadMoreUIHandler handler);


    /**
     * set auto load-more
     * @param autoLoadMore auto or not
     */
    public void setAutoLoadMore(boolean autoLoadMore);

    /**
     * change state to load-more-finished
     * @param emptyData empty list data or not
     * @param hasMore   more data or not
     */
    public void loadMoreFinished(boolean emptyData, boolean hasMore);


    /**
     * change state to load-more-failed
     */
    public void loadMoreFailed();


    public void setLoadMoreView(View view);

    public void setShowLoadingForFirstPage(boolean showLoading);
}
