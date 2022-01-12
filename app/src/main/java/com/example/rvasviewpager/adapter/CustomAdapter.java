package com.example.rvasviewpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvasviewpager.R;
import com.example.rvasviewpager.model.Education;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Education> educations;

    public CustomAdapter(Context context, ArrayList<Education> educations) {
        this.context = context;
        this.educations = educations;
    }


    @Override
    public int getItemCount() {
        return educations.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_layout_view, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Education education = educations.get(position);
        if (holder instanceof CustomViewHolder){
            TextView name = ((CustomViewHolder)holder).name;
            TextView project = ((CustomViewHolder)holder).project;

            name.setText(education.getName());
            project.setText(education.getProjectName());
        }
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public TextView project;

        public CustomViewHolder(View v) {
            super(v);
            this.view = v;
            name = view.findViewById(R.id.tv_educationCenter);
            project = view.findViewById(R.id.tv_projectName);
        }
    }


}
