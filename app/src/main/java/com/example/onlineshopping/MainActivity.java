package com.example.onlineshopping;



import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineshopping.database.ShoppingDBHelper;
import com.example.onlineshopping.database.models.Order;
import com.example.onlineshopping.database.models.OrderDetials;
import com.example.onlineshopping.database.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                ShoppingDBHelper dbHelper ;
                dbHelper=new ShoppingDBHelper(this );
                dbHelper.insertCustomer("admin","rengo","123","male","admin","mm/dd/yy",1,"000");

                Intent intent = new Intent(getApplicationContext(), Login.class);

                startActivity(intent);





    }

}