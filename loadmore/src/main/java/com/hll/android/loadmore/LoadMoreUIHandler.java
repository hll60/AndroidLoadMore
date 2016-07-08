package com.hll.android.loadmore;

/**
 * Created by lin on 2016/7/8.
 */
public interface LoadMoreUIHandler {

    public void onLoading(LoadMoreContainer loadMoreContainer);

    public void onLoadFinished(LoadMoreContainer loadMoreContainer, boolean emptyData, boolean hasMore);

    public void onLoadFailed(LoadMoreContainer loadMoreContainer);

    /**
     * waiting user to perform load-more action
      * @param loadMoreContainer
     */
    public void onWaiting(LoadMoreContainer loadMoreContainer);



}
