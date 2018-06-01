package com.example.banner.houserentalapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.banner.houserentalapp.R;
import com.github.siyamed.shapeimageview.RoundedImageView;

public class EstateAdapter extends RecyclerView.Adapter<EstateAdapter.ViewHolder> {

    Context context;
    String url="https://images.unsplash.com/photo-1463392898715-3939d4ab1019?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjI0MX0&s=0057f97eeacbc3f31514f5b309a736e7";
    String TAG=EstateAdapter.class.getSimpleName();
    int type;

    public EstateAdapter(Context context,int type) {
        this.context = context;
        this.type=type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView;

        if(type==0)
         rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_houses_layout, parent, false);
        else
            rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.real_estate_layout, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(type==0) {
            Glide.with(context).load(R.drawable.bernar)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Log.d(TAG, "Exception=" + e);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(holder.poster);


        }
        else{
            Glide.with(context).load(R.drawable.bernar).into(holder.mainPoster);
            Glide.with(context).load(R.drawable.breather).into(holder.preview1);
            Glide.with(context).load(R.drawable.nathan).into(holder.preview2);

        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView poster,mainPoster,preview1,preview2;
        public ViewHolder(View itemView) {
            super(itemView);

            if (type == 0){
                poster = itemView.findViewById(R.id.roundedImageView);
            }
            else{
                mainPoster=itemView.findViewById(R.id.roundedImageView);
                preview1=itemView.findViewById(R.id.preview1);
                preview2=itemView.findViewById(R.id.preview2);
            }

        }
    }
}
