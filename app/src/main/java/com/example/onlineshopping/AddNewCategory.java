package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.onlineshopping.database.ShoppingDBHelper;

public class AddNewCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_category);

        EditText categoryName = findViewById(R.id.categoryName);
        Button addBtn =  findViewById(R.id.addCategoryBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String catName = categoryName.getText().toString();

                ShoppingDBHelper db = new ShoppingDBHelper(AddNewCategory.this);
                db.insertCategory(catName);

                categoryName.setText("");
            }
        });
    }
}