package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.onlineshopping.R;
import com.example.onlineshopping.database.ShoppingDBHelper;

public class CategoryUpdate extends AppCompatActivity {
    String categoryID, categoryName;
    EditText categoryNameEditText;
    Button updateBtn,deleteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_update);
        categoryNameEditText = findViewById(R.id.categoryName);

        updateBtn =  findViewById(R.id.updateCategoryBtn);
        deleteBtn =  findViewById(R.id.deleteCategoryBtn);
        getAndSetIntentData();
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("MY ID IS : "+categoryID);
                categoryName = categoryNameEditText.getText().toString();
                ShoppingDBHelper dbHelper = new ShoppingDBHelper(CategoryUpdate.this);
                dbHelper.updateCategory(categoryID,categoryName);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }
    void getAndSetIntentData(){

        if(getIntent().hasExtra("categoryID")){
            categoryID = getIntent().getStringExtra("categoryID");
            categoryName = getIntent().getStringExtra("categoryName");

            categoryNameEditText.setText(categoryName);
        } else {
            System.out.println("DATA NULL");
        }
//        if(getIntent().hasExtra("categoryID")){
//            categoryID = getIntent().getStringExtra("categoryID");
//            categoryName = getIntent().getStringExtra("categoryName");
//
//            categoryNameEditText.setText(categoryName);
//
//        }
    }



    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + categoryName + " ?");
        builder.setMessage("Are you sure you want to delete " + categoryName + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ShoppingDBHelper myDB = new ShoppingDBHelper(CategoryUpdate.this);
                myDB.deleteOneCategory(categoryID);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}