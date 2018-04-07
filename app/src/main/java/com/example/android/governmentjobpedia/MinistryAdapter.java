package com.example.android.governmentjobpedia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MinistryAdapter extends RecyclerView.Adapter<MinistryAdapter.MyViewHolder> {

    ArrayList<Integer> modelArrayList;
    Context context;
    ClickListener listener;

    public MinistryAdapter(ArrayList<Integer> modelArrayList, Context context, ClickListener listener) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public MinistryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.ministry_item, parent, false);
        final MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getAdapterPosition());
            }
        });
        Log.d("mytag", "inside oncreate view holder");
        return holder;
    }

    @Override
    public void onBindViewHolder(MinistryAdapter.MyViewHolder holder, int position) {
        //holder.ministryName.setText(modelArrayList.get(position));
        holder.ministryImage.setImageResource(modelArrayList.get(position));
        // Log.d("myTag", modelArrayList.get(position));
        //TODO: set glide image using list

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ministryImage;
        TextView ministryName;

        public MyViewHolder(View itemView) {
            super(itemView);
            ministryImage = itemView.findViewById(R.id.image_ministry);
        }
    }

    public interface ClickListener {
        void onItemClick(View v, int position);

    }
}
