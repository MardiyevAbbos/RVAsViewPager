package com.example.rvasviewpager.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.rvasviewpager.R;
import com.example.rvasviewpager.adapter.CustomAdapter;
import com.example.rvasviewpager.model.Education;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Education> educations = prepareEducationList();
        refreshAdapter(educations);

    }


    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                assert layoutManager != null;
                int activePosition = layoutManager.findFirstVisibleItemPosition();
                if (activePosition == RecyclerView.NO_POSITION) return;
                Log.d("@@@@", "activePosition: " + activePosition);
            }
        });

    }


    private void refreshAdapter(ArrayList<Education> educations) {
        CustomAdapter adapter = new CustomAdapter(context, educations);
        recyclerView.setAdapter(adapter);
    }


    private ArrayList<Education> prepareEducationList() {
        ArrayList<Education> educations = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            educations.add(new Education(i + ")PDP Academy", i + ")Unicorn"));
        }
        return educations;
    }


}