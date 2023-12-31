package com.example.onlineshopping;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;

import com.example.onlineshopping.ui.ProductDetails;
import com.example.onlineshopping.ui.fragments.AdminFragmentsAdapter;
import com.google.android.material.tabs.TabLayout;

import android.view.View;
import android.widget.Toast;

import com.example.onlineshopping.database.ShoppingDBHelper;
import com.example.onlineshopping.ui.AddActivity;
import com.example.onlineshopping.ui.adapter.CustomAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;



public class AdminHome extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    AdminFragmentsAdapter adminFragmentsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        adminFragmentsAdapter = new AdminFragmentsAdapter(this);
        viewPager2.setAdapter(adminFragmentsAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                Toast.makeText(AdminHome.this, tab.getPosition(), Toast.LENGTH_LONG).show();
                Log.d("Tag",String.valueOf(tab.getPosition()));
                viewPager2.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode ==1){
            recreate();
        }
    }

}