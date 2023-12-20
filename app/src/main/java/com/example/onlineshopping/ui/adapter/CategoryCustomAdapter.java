package com.example.onlineshopping.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.CategoryUpdate;
import com.example.onlineshopping.R;

import java.util.ArrayList;

public class CategoryCustomAdapter extends RecyclerView.Adapter<CategoryCustomAdapter.MyViewHolder> {
    Context context;
    Activity activity;
    ArrayList categoryID, categoryName;
    // int position;
    public CategoryCustomAdapter(Activity activity, Context context, ArrayList categoryID, ArrayList categoryName) {
        this.activity = activity;
        this.context = context;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_recycle_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.categoryID.setText(String.valueOf(categoryID.get(position)));
        holder.categoryName.setText(String.valueOf(categoryName.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CategoryUpdate.class);
                intent.putExtra("categoryID",String.valueOf(categoryID.get(position)));
                intent.putExtra("categoryName",String.valueOf(categoryName.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryID.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView categoryID, categoryName;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryID = itemView.findViewById(R.id.productID);
            categoryName = itemView.findViewById(R.id.categoryName);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

