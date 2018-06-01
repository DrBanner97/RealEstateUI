package com.example.banner.houserentalapp;

import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class SnapHelperOneByOne extends LinearSnapHelper {

    public static String TAG=SnapHelperOneByOne.class.getSimpleName();

    @Override
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {

//        Log.d(TAG,"findTargetSnapPosition velocityX="+velocityX);



        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            Log.d(TAG,"1st if");

            return RecyclerView.NO_POSITION;
        }

        final View currentView = findSnapView(layoutManager);

        if( currentView == null ){
            Log.d(TAG,"2nd if");
            return RecyclerView.NO_POSITION;
        }

        final int currentPosition = layoutManager.getPosition(currentView);

        if (currentPosition == RecyclerView.NO_POSITION) {
            Log.d(TAG,"3rd if");

            return RecyclerView.NO_POSITION;
        }

        if(velocityX>3000){
            return currentPosition+1;
        }

        return currentPosition;
    }
}
