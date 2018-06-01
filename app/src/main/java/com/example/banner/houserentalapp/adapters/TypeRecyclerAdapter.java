package com.example.banner.houserentalapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.banner.houserentalapp.R;

import java.util.List;

public class TypeRecyclerAdapter extends RecyclerView.Adapter<TypeRecyclerAdapter.Viewholder> {

    Context context;
    List<String> types;
    String TAG = TypeRecyclerAdapter.class.getSimpleName();

    Viewholder selectedItemViewHolder = null;
    int selectedPosition;

    float scale;
    int dpAsPixels;

    public TypeRecyclerAdapter(Context context, List<String> types) {
        this.context = context;
        this.types = types;
        scale = context.getResources().getDisplayMetrics().density;
        dpAsPixels = (int) (16 * scale + 0.5f);
        selectedPosition=types.size()+1;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_layout, parent, false);
        return new Viewholder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder holder, final int position) {
        holder.type.setText(types.get(position));
        holder.typeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (selectedPosition == position) {
                    Log.d(TAG,"currently selected unselected ");

                    unselectItem(holder);
                } else {

                    if (selectedItemViewHolder != null) {
                        unselectItem(selectedItemViewHolder);
                        Log.d(TAG,"previously selected unselected ");

                    }

                    setItemSelected(holder, position);
                    Log.d(TAG,"new selection");

                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView type;
        FrameLayout typeLayout;

        public Viewholder(View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            typeLayout = itemView.findViewById(R.id.type_layout);


        }

    }


    public void setItemSelected(Viewholder itemViewHolder, int position) {

        itemViewHolder.type.setTextColor(context.getResources().getColor(R.color.pure_white));
        itemViewHolder.typeLayout.setBackgroundResource(R.drawable.pill_shape_blue);
        itemViewHolder.typeLayout.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels);

        selectedItemViewHolder = itemViewHolder;
        selectedPosition = position;

    }

    public void unselectItem(Viewholder itemViewHolder) {
        itemViewHolder.typeLayout.setBackgroundResource(R.drawable.pill_shape_white);
        itemViewHolder.type.setTextColor(context.getResources().getColor(R.color.black_text_color));
        itemViewHolder.typeLayout.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels);
        itemViewHolder.typeLayout.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels);

    }
}
