package com.hll.android.loadmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by lin on 2016/7/8.
 */
public class LoadMoreDefaultView extends RelativeLayout implements LoadMoreUIHandler{

    private TextView mTextView;

    public LoadMoreDefaultView(Context context) {
        super(context);
        initView();
    }

    public void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.loadmore_default, this);
        mTextView = (TextView) findViewById(R.id.load_more_default_text_view);
    }

    @Override
    public void onLoading(LoadMoreContainer loadMoreContainer) {
        setVisibility(VISIBLE);
        mTextView.setText(R.string.load_more_loading);
    }

    @Override
    public void onLoadFinished(LoadMoreContainer loadMoreContainer, boolean emptyData, boolean hasMore) {

        if(emptyData){
            setVisibility(VISIBLE);
            mTextView.setText(R.string.load_more_load_finished_empty_data);
        }else if(hasMore){
            setVisibility(GONE);
        }else{
            setVisibility(VISIBLE);
            mTextView.setText(R.string.load_more_load_finished_no_more);
        }

    }

    @Override
    public void onLoadFailed(LoadMoreContainer loadMoreContainer) {
        setVisibility(VISIBLE);
        mTextView.setText(R.string.load_more_load_failed);
    }

    @Override
    public void onWaiting(LoadMoreContainer loadMoreContainer) {
        setVisibility(VISIBLE);
        mTextView.setText(R.string.load_more_click_to_load_more);
    }
}
