package com.example.android.governmentjobpedia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MinistryListAdapter extends RecyclerView.Adapter<MinistryListAdapter.MyViewHolder> {

    Context context;
    ArrayList<Model> modelArrayList;
    ClickListener listener;

    public MinistryListAdapter(Context context, ArrayList<Model> modelArrayList, ClickListener listener) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.listener = listener;
    }

    public interface ClickListener {
        void onItemClick(View v, int position);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.job_details, parent, false);
        final MinistryListAdapter.MyViewHolder holder = new MinistryListAdapter.MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getAdapterPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.positionValue.setText(modelArrayList.get(position).position);
        holder.locationName.setText(modelArrayList.get(position).location);
        holder.applyName.setText(modelArrayList.get(position).applyBy);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView positionValue;
        TextView locationName;
        TextView applyName;

        public MyViewHolder(View itemView) {
            super(itemView);
            positionValue = itemView.findViewById(R.id.position_name);
            locationName = itemView.findViewById(R.id.location_value_name);
            applyName = itemView.findViewById(R.id.apply_value_name);
        }
    }
}
