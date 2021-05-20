package com.js.favoriteapp.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class CategoryManager {


    private Context mContext;

    public CategoryManager(Context mContext) {
        this.mContext = mContext;
    }



    //Save data to sharedPreferences
    public void saveCategory(Category1 category){


        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        HashSet itemsHashSet=new HashSet(Arrays.asList(category.getItems()));

        editor.putStringSet(category.getName1(),itemsHashSet);

        editor.apply();
    }

    //Retrieve data from sharedPreferences

    public ArrayList<Category1> retrieveCategories(){
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(mContext);
        Map<String,?> data=sharedPreferences.getAll();

        ArrayList<Category1> category1s=new ArrayList<>();
        for(Map.Entry<String,?> entry:data.entrySet()){
            Category1 category1=new Category1(entry.getKey(),new ArrayList<String>((HashSet) entry.getValue()));
            category1s.add(category1);
        }
        return  category1s;
    }

}
