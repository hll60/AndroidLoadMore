package com.hll.android.loadmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by lin on 2016/7/8.
 */
public class LoadMoreListViewContainer extends LoadMoreContainerBase {

    private ListView mListView;

    public LoadMoreListViewContainer(Context context) {
        super(context);
    }

    public LoadMoreListViewContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void addLoadMoreView(View view) {
        mListView.addFooterView(view);
    }

    @Override
    protected void removeLoadMoreView(View view) {
        mListView.removeFooterView(view);
    }

    @Override
    protected AbsListView getAbsListView() {
        try {
            mListView = (ListView) getChildAt(0);
            return mListView;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("LoadMoreListView must have only one ListView child");
        }
    }
}
