package com.epicodus.myrestaurants.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.myrestaurants.models.Restaurant;
import com.epicodus.myrestaurants.ui.RestaurantDetailFragment;

import java.util.ArrayList;

/**
 * Created by amati on 9/2/2017.
 */

public class RestaurantPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Restaurant> myRestaurants;

    public RestaurantPagerAdapter(FragmentManager fm,ArrayList<Restaurant> restaurants){
        super(fm);
        myRestaurants = restaurants;
    }

    @Override
    public Fragment getItem(int position) {
        return RestaurantDetailFragment.newInstance(myRestaurants.get(position));
    }

    @Override
    public int getCount() {
        return myRestaurants.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return myRestaurants.get(position).getName();
    }
}
