package com.js.favoriteapp.model;

import java.util.ArrayList;

public class Category1 {

    private String name1;
    private ArrayList<String> items = new ArrayList<>();

    public Category1(String name1, ArrayList<String> items) {
        this.name1 = name1;
        this.items = items;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}
