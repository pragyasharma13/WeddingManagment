package com.example.weddingmanagemnt1;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;


public class RecyclerClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mOnClickListener;
    GestureDetector mGestureDetector;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public RecyclerClickListener(Context context, OnItemClickListener listener) {
        mOnClickListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mOnClickListener != null && mGestureDetector.onTouchEvent(e)) {
            mOnClickListener.onItemClick(childView, view.getChildPosition(childView));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

}