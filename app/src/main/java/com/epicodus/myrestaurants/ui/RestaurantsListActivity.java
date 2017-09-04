package com.epicodus.myrestaurants.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.myrestaurants.R;
import com.epicodus.myrestaurants.adapters.RestaurantListAdapter;
import com.epicodus.myrestaurants.models.Restaurant;
import com.epicodus.myrestaurants.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RestaurantsListActivity extends AppCompatActivity {
    public static final String TAG = RestaurantsListActivity.class.getSimpleName();
    @Bind(R.id.recycleView) RecyclerView myRecyclerView;

    private RestaurantListAdapter myAdapter;
    public ArrayList<Restaurant> myRestaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("Location");
        getReastaurants(location);

    }
    private void getReastaurants(String location){
        final YelpService yelpService = new YelpService();
        yelpService.findResturants(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e){
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) {
                myRestaurants = yelpService.processResults(response);

                RestaurantsListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myAdapter = new RestaurantListAdapter(getApplicationContext(),myRestaurants);

                        myRecyclerView.setAdapter(myAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantsListActivity.this);
                        myRecyclerView.setLayoutManager(layoutManager);
                        myRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
