package com.example.banner.houserentalapp.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.banner.houserentalapp.R;


@SuppressWarnings("unused")
public class HeaderBehavior extends CoordinatorLayout.Behavior<ImageView> {
    String TAG=HeaderBehavior.class.getSimpleName();

    private float mCustomFinalYPosition;
    private float mCustomStartXPosition;
    private float mCustomStartToolbarPosition;
    private float mCustomStartHeight;
    private float mCustomFinalHeight;

    public HeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);

        if(attrs!=null){
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HeaderBehavior);
            mCustomFinalYPosition = a.getDimension(R.styleable.HeaderBehavior_finalYPosition, 0);

            mCustomStartXPosition = a.getDimension(R.styleable.HeaderBehavior_startXPosition, 0);
            mCustomStartToolbarPosition = a.getDimension(R.styleable.HeaderBehavior_startToolbarPosition, 0);
            mCustomStartHeight = a.getDimension(R.styleable.HeaderBehavior_startHeight, 0);
            mCustomFinalHeight = a.getDimension(R.styleable.HeaderBehavior_finalHeight, 0);

//            Log.d(TAG,"styleable finalYPosition="+R.styleable.HeaderBehavior_finalYPosition+" mCustomFinalYPosition="+mCustomFinalYPosition);
//            Log.d(TAG,"styleable mCustomStartXPosition="+R.styleable.HeaderBehavior_startXPosition+" mCustomStartXPosition="+mCustomStartXPosition);
//            Log.d(TAG,"styleable mCustomStartToolbarPosition="+R.styleable.HeaderBehavior_startToolbarPosition+" mCustomStartToolbarPosition="+mCustomStartToolbarPosition);
//            Log.d(TAG,"styleable mCustomStartHeight="+R.styleable.HeaderBehavior_startHeight+" mCustomStartHeight="+mCustomStartHeight);
//            Log.d(TAG,"styleable mCustomFinalHeight="+R.styleable.HeaderBehavior_finalHeight+" mCustomFinalHeight="+mCustomFinalHeight);

            a.recycle();


        }
//        Log.d(TAG,"HeaderBehavior Constructor attrs="+attrs);

    }

//    @Override
//    public boolean onDependentViewChanged(CoordinatorLayout parent, LinearLayout child, View dependency) {
//        Log.d(TAG,"dependent view changed="+dependency.getTranslationY()+" child="+child.getTranslationY()+" parent="+parent.getNestedScrollAxes());
//        return super.onDependentViewChanged(parent, child, dependency);
//    }
//
//    @Override
//    public boolean layoutDependsOn(CoordinatorLayout parent, LinearLayout child, View dependency) {
//        return dependency instanceof Toolbar;
//    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
//        Log.d(TAG,"layoutDependsOn"+dependency.getY());

        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {

        Log.d(TAG,"dependent view changed="+dependency.getY());
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
