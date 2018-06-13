package hatetags.com.hatetags;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerViewTouchActions implements RecyclerView.OnItemTouchListener {

    private RecyclerView recyclerView;
    private OnRecyclerViewListener recyclerViewTouchListener;
    private GestureDetector gestureDetector;

    public RecyclerViewTouchActions(Context context, RecyclerView recyclerView, OnRecyclerViewListener recyclerViewTouchListener) {
        this.recyclerView = recyclerView;
        this.recyclerViewTouchListener = recyclerViewTouchListener;
        gestureDetector = new GestureDetector(context, onSimpleGestureListener());
    }

    private GestureDetector.SimpleOnGestureListener onSimpleGestureListener() {
        return new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                View clickedView = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(clickedView != null && recyclerViewTouchListener != null)
                    recyclerViewTouchListener.onItemClick(clickedView, recyclerView.getChildAdapterPosition(clickedView));

                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                View clickedView = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(clickedView != null && recyclerViewTouchListener != null)
                    recyclerViewTouchListener.onLongItemClick(clickedView, recyclerView.getChildAdapterPosition(clickedView));
            }
        };
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recycleView, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) { }
}
