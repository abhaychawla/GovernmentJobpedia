package com.example.android.governmentjobpedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MinistryJobActivity extends AppCompatActivity {

    RecyclerView jobList;
    MinistryListAdapter ministryAdapter;
    ArrayList<Model> modelList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ministry_job_screen);

        jobList = findViewById(R.id.job_list);
        jobList.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        jobList.setLayoutManager(mLayoutManager);
        ministryAdapter = new MinistryListAdapter(this,modelList,  new MinistryListAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //Todo handle item click
//                Intent intent = new Intent(MinistryJobActivity.this, MinistryJobActivity.class);
//                intent.putExtra("myTag", position);
//                startActivity(intent);
            }
        });

        jobList.setAdapter(ministryAdapter);
    }
}
