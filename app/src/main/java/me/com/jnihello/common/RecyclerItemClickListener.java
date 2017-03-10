package me.com.jnihello.common;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import me.com.jnihello.adapter.RecyAdapter;

/**
 * Created by xulu on 2017/3/9.
 */

public abstract class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener{
    private GestureDetectorCompat gesDetector;
    private RecyclerView recyclerView;

    public RecyclerItemClickListener(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        gesDetector = new GestureDetectorCompat(recyclerView.getContext(),new ItemTouchHelperGesListener());
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        gesDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        gesDetector.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    private class ItemTouchHelperGesListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
            if(child!=null){
                RecyAdapter.recyViewHolder holder = (RecyAdapter.recyViewHolder)recyclerView.getChildViewHolder(child);
                int position = recyclerView.getChildAdapterPosition(child);
                onItemClick(holder,position);
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
            View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
            if(child!=null){
                RecyAdapter.recyViewHolder holder = (RecyAdapter.recyViewHolder)recyclerView.getChildViewHolder(child);
                int position = recyclerView.getChildAdapterPosition(child);
                onItemLongClick(holder,position);
            }
        }
    }


    public abstract void onItemClick(RecyAdapter.recyViewHolder holder,int position);
    public abstract void onItemLongClick(RecyAdapter.recyViewHolder holder,int position);

}
