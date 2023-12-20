package com.example.onlineshopping.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshopping.R;
import com.example.onlineshopping.database.ShoppingDBHelper;
import com.example.onlineshopping.database.models.Category;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EditText productNameText = findViewById(R.id.productName);
        EditText productPriceText =  findViewById(R.id.price);
        EditText productStockQuantityText = findViewById(R.id.stockQuantity);
        EditText productBarcodeText =  findViewById(R.id.barcode);
        EditText productSalesNumberText =  findViewById(R.id.salesNumber);
        EditText productCategoryText =  findViewById(R.id.category);
        Button addBtn =  findViewById(R.id.addProductBtn);
        //Product product = new Product(productId,productName,productPrice,productStockQuantity,productBarcode,productCategoryو);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = productNameText.getText().toString();
                String productCategory = productCategoryText.getText().toString();
                String productBarcode = productBarcodeText.getText().toString();
                int productStockQuantity = Integer.parseInt(productStockQuantityText.getText().toString());
                int productPrice = Integer.parseInt(productPriceText.getText().toString());
                int productSalesNumber = Integer.parseInt(productSalesNumberText.getText().toString());

                System.out.println("name is"+productName);
                System.out.println("hello");
                ShoppingDBHelper db = new ShoppingDBHelper(AddActivity.this);
                List<Category> catList = db.getAllCategory();
                String[] list = new String[catList.size()];
                int i=0;
                for (Category c: catList
                     ) {
//                    list[i] = c.getCategoryName();
//                    i++;
                    if(c.getCategoryName().equals(productCategory)){
                       i=1;
                    }
                }
                if(i==1){
                    db.addProduct( productName, productPrice, productStockQuantity, productBarcode,
                            productSalesNumber, productCategory);
                    productNameText.setText("");
                    productCategoryText.setText("");
                    productBarcodeText.setText("");
                    productStockQuantityText.setText("");
                    productPriceText.setText("");
                    productSalesNumberText.setText("");
                }


            }
        });

    }
}