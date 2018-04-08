package com.example.android.governmentjobpedia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MinistryJobActivity extends AppCompatActivity {

    RecyclerView jobList;
    MinistryListAdapter ministryAdapter;
    ArrayList<Model> modelList;
    final String url = "http://192.168.1.101:8081/api/jobs";
    String tag_json_obj = "myTag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ministry_job_screen);

        jobList = findViewById(R.id.job_list);
        jobList.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        jobList.setLayoutManager(mLayoutManager);
        modelList = new ArrayList<>();
        ministryAdapter = new MinistryListAdapter(this, modelList, new MinistryListAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //Todo handle item click
//                Intent intent = new Intent(MinistryJobActivity.this, MinistryJobActivity.class);
//                intent.putExtra("myTag", position);
//                startActivity(intent);
            }
        });

        jobList.setAdapter(ministryAdapter);
        createDataInformation();
    }

    private void createDataInformation() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Information...");
        progressDialog.show();
        Log.d("myTag", url);
        Model model;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("myTag", response.toString());
                Model model;
                progressDialog.hide();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject job = response.getJSONObject(i);
                        model = new Model(job.getString("ministryName"),
                                job.getString("orgName"),
                                job.getString("description"),
                                job.getString("position"),
                                job.getString("applyBy"),
                                job.getString("location"),
                                job.getString("eligibility"));
                        modelList.add(model);
                        ministryAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("myTag", error.toString());
                        progressDialog.hide();
                        Toast.makeText(MinistryJobActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest, tag_json_obj);
    }


}
