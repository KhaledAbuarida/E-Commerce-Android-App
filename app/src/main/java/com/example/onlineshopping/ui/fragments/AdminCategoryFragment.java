package com.example.onlineshopping.ui.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.onlineshopping.AddNewCategory;
import com.example.onlineshopping.R;
import com.example.onlineshopping.database.ShoppingDBHelper;
import com.example.onlineshopping.ui.adapter.CategoryCustomAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdminProductsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdminCategoryFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdminCategoryFragment() {
        // Required empty public constructor
    }


    public static AdminCategoryFragment newInstance(String param1, String param2) {
        AdminCategoryFragment fragment = new AdminCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    RecyclerView recyclerView;

    ShoppingDBHelper dbHelper;
    //ArrayList<Integer> productID, productQuantity, productPrice,productSalesNumber;
    ArrayList<String> categoryID, categoryName;
    CategoryCustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_admin_categories,container,false);

        recyclerView = rootView.findViewById(R.id.recycleViewID);
        FloatingActionButton addButton = (FloatingActionButton) rootView.findViewById(R.id.addBtn);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddNewCategory.class);
               startActivity(intent);
            }
        });


        dbHelper = new ShoppingDBHelper(getActivity());
        categoryID = new ArrayList<>();
        categoryName = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CategoryCustomAdapter(getActivity(),getActivity(),categoryID,categoryName);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;/*inflater.inflate(R.layout.fragment_admin_products, container, false);*/
    }

    void storeDataInArrays(){
        Cursor cursor = dbHelper.readAllCategories();
        if(cursor.getCount() == 0){
            Toast.makeText(getActivity(),"No Data", Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                categoryID.add(cursor.getString(0));
                categoryName.add(cursor.getString(1));
            }
        }
    }
}