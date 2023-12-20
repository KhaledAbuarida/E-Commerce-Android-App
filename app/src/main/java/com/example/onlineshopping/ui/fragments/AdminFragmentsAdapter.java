package com.example.onlineshopping.ui.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdminFragmentsAdapter extends FragmentStateAdapter {
    public AdminFragmentsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(position == 0){
            return new AdminProductsFragment();
        }
        else if (position == 1){
            return new AdminCategoryFragment();
        }
        else if (position == 2){
            return new OrdersFragment();
        }
        else if (position == 3) {
            return new ChartFragment();
        }
        else {
            return new AdminProductsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
