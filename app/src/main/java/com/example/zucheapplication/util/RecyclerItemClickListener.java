package com.example.zucheapplication.util;


import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 自定义item点击事件
 * email 1005196988@qq.com
 *
 * @author bingyi
 * @date 2021/6/3/0003 21:01
 */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    GestureDetector mGestureDetector;
    private View childView;
    private RecyclerView touchView;

    public RecyclerItemClickListener(Context context, final OnItemClickListener mListener) {
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent ev) {
                if (childView != null && mListener != null) {
                    mListener.onItemClick(childView, touchView.getChildPosition(childView));
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent ev) {
                if (childView != null && mListener != null) {
                    mListener.onLongClick(childView, touchView.getChildPosition(childView));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        childView = rv.findChildViewUnder(e.getX(), e.getY());
        touchView = rv;
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }


    public interface OnItemClickListener {
        /**
         * 点击项
         *
         * @param view     视图
         * @param position 操作
         */
        void onItemClick(View view, int position);

        /**
         * 长按
         *
         * @param view     视图
         * @param position 操作
         */
        void onLongClick(View view, int position);
    }
}
