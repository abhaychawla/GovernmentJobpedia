package com.example.android.governmentjobpedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MinistryAdapter ministryAdapter;
    ArrayList<Model> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        generateFakeData();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new android.support.v7.widget.DefaultItemAnimator());
        ministryAdapter = new MinistryAdapter(modelList, this, new MinistryAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //Todo handle item click
                Log.d("myTag", "clicked");
            }
        });
        recyclerView.setAdapter(ministryAdapter);


    }

    private void generateFakeData() {
        Model model;
        modelList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            model = new Model("HRD", "orgs1", "about job",
                    "director", "this date", "delhi", "engineering");
            modelList.add(model);
            Log.d("mytag", "generating fake data");
        }
    }


}
