package com.js.favoriteapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private TextView textNumber;
    private TextView textData;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        textNumber=itemView.findViewById(R.id.textView);
        textData=itemView.findViewById(R.id.textView2);

    }

    public TextView getTextNumber() {
        return textNumber;
    }

    public void setTextNumber(TextView textNumber) {
        this.textNumber = textNumber;
    }

    public TextView getTextData() {
        return textData;
    }

    public void setTextData(TextView textData) {
        this.textData = textData;
    }
}
