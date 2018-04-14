package com.example.android.governmentjobpedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MinistryAdapter ministryAdapter;
    ArrayList<Integer> modelList;
    Button buttonAllJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        buttonAllJobs = findViewById(R.id.button);
        recyclerView.setHasFixedSize(true);
        generateImageData();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new android.support.v7.widget.DefaultItemAnimator());

        ministryAdapter = new MinistryAdapter(modelList, this, new MinistryAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //Todo handle item click
                Log.d("myTag", "clicked");
                Intent intent = new Intent(MainActivity.this, MinistryJobActivity.class);
                intent.putExtra("myTag", position);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(ministryAdapter);
        buttonAllJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MinistryJobActivity.class);
                intent.putExtra("myTag", 10);
                startActivity(intent);
            }
        });


    }

    private void generateImageData() {
        modelList = new ArrayList<>();
        modelList.add(R.drawable.home_affairs_100_100);
        modelList.add(R.drawable.commerce_100_100);
        modelList.add(R.drawable.coal_100_100);
        modelList.add(R.drawable.power_100_100);
        modelList.add(R.drawable.textiles_100_100);
        Collections.reverse(modelList);

//        for (int i = 0; i < 6; i++) {
//            model = new Model("HRD", "orgs1", "about job",
//                    "director", "this date", "delhi", "engineering");
//            modelList.add(model);
//            Log.d("mytag", "generating fake data");
//        }
    }


}
