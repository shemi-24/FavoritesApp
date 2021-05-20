package com.js.favoriteapp;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.js.favoriteapp.adapter.CategoryAdapter;
import com.js.favoriteapp.model.Category;
import com.js.favoriteapp.model.Category1;
import com.js.favoriteapp.model.CategoryManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
//    List<Category> getList;
    private CategoryManager categoryManager=new CategoryManager(MainActivity.this);
//    private Category1 category1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        getList=new ArrayList<>();
//        getList.add(new Category("abcd"));
//        getList.add(new Category(("dcsg")));

        ArrayList<Category1> category1s=categoryManager.retrieveCategories();


         recyclerView=findViewById(R.id.category_recyclerview);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         categoryAdapter=new CategoryAdapter(category1s, MainActivity.this);
         recyclerView.setAdapter(categoryAdapter);


         FloatingActionButton fab=findViewById(R.id.fab);
         fab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Snackbar.make(v,"Add a new data",Snackbar.LENGTH_SHORT).show();


                 displayCreateCategoryDialog();
             }
         });

         //////

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private void displayCreateCategoryDialog(){

        String alertTitle="Enter the name of the category";
        String positiveBtnTilte="Create";

        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        EditText categoryEditText=new EditText(this);
        categoryEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        alert.setTitle(alertTitle);
        alert.setView(categoryEditText);
        alert.setPositiveButton(positiveBtnTilte, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                Category1 category1=new Category1(categoryEditText.getText().toString(),new ArrayList<String>());
                categoryManager.saveCategory(category1);

                CategoryAdapter categoryAdapter= (CategoryAdapter) recyclerView.getAdapter();
                categoryAdapter.addCategory(category1);



                dialog.dismiss();
            }
        });

        alert.create().show();



    }
}