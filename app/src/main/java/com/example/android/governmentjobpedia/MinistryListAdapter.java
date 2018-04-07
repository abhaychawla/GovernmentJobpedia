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
        holder.organisationName.setText(modelArrayList.get(position).organisation);
        holder.positionValue.setText(modelArrayList.get(position).position);
        holder.locationName.setText(modelArrayList.get(position).location);
        holder.dateName.setText(modelArrayList.get(position).applyBy);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.organisation_name)
        TextView organisationName;

        @BindView(R.id.position_value_name)
        TextView positionValue;

        @BindView(R.id.location_value_name)
        TextView locationName;

        @BindView(R.id.date_value_name)
        TextView dateName;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
