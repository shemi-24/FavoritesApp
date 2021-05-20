package com.js.favoriteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.js.favoriteapp.CategoryViewHolder;
import com.js.favoriteapp.R;
import com.js.favoriteapp.model.Category;
import com.js.favoriteapp.model.Category1;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {


    ArrayList<Category1> categoryList;
    Context context;

    public CategoryAdapter(ArrayList<Category1> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.adpater_layout,parent,false);
        return new CategoryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
    holder.getTextNumber().setText(Integer.toString(position));
    holder.getTextData().setText( categoryList.get(position).getName1());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void addCategory(Category1 category1){
        categoryList.add(category1);
        notifyItemInserted(categoryList.size()-1);
    }
}
