package com.example.banner.houserentalapp.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;

import com.example.banner.houserentalapp.R;
import com.example.banner.houserentalapp.SnapHelperOneByOne;
import com.example.banner.houserentalapp.adapters.EstateAdapter;
import com.example.banner.houserentalapp.adapters.TypeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

        RecyclerView featuredRecyclerView,typeRecyclerView,realEstateRecycler;
        List<String> types;
        Toolbar toolbar;

        public static String TAG=HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home);
        types= new ArrayList<>();
        types.add("Villa");
        types.add("Apartment");
        types.add("Studio");
        types.add("Room");
        types.add("Commercial");


        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realEstateRecycler=findViewById(R.id.real_estate_recycler);
        realEstateRecycler.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        realEstateRecycler.setAdapter(new EstateAdapter(HomeActivity.this,1));
        realEstateRecycler.setNestedScrollingEnabled(false);


        featuredRecyclerView =findViewById(R.id.featured_recycler);
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false);
        featuredRecyclerView.setLayoutManager(linearLayoutManager);
        featuredRecyclerView.setAdapter(new EstateAdapter(HomeActivity.this ,0));
//        SnapHelper snapHelper = new LinearSnapHelper();
//        snapHelper.attachToRecyclerView(featuredRecyclerView);

//        featuredRecyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
//            @Override
//            public boolean onFling(int velocityX, int velocityY) {
//                int position=linearLayoutManager.findFirstCompletelyVisibleItemPosition();
//                linearLayoutManager.scrollToPosition(position);
//                return false;
//            }
//        });

        featuredRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Log.d(TAG,"onScrolled dx="+dx+" dy="+dy);

                super.onScrolled(recyclerView, dx, dy);
                int position=linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                linearLayoutManager.scrollToPosition(position);
            }
        });




        typeRecyclerView=findViewById(R.id.type_recycler);
        typeRecyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false));
        typeRecyclerView.setAdapter(new TypeRecyclerAdapter(HomeActivity.this,types));

        Window window = HomeActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(HomeActivity.this,R.color.white));


    }
}
