package com.epicodus.myrestaurants.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.myrestaurants.R;
import com.epicodus.myrestaurants.models.Restaurant;
import com.epicodus.myrestaurants.ui.RestaurantDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by amati on 9/1/2017.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>{
    private ArrayList<Restaurant> myRestaurants = new ArrayList<>();
    private Context myContext;

    public RestaurantListAdapter(Context context, ArrayList<Restaurant> restaurants){
        myRestaurants = restaurants;
        myContext = context;
    }

    @Override
    public RestaurantListAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item,parent,false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RestaurantListAdapter.RestaurantViewHolder holder, int position) {
        holder.bindRestaurant(myRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return myRestaurants.size();
    }



    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.restaurantImageView) ImageView myRestaurantImageView;
        @Bind(R.id.restaurantNameTextView) TextView myNameTextView;
        @Bind(R.id.categoryTextView) TextView myCategoryTextView;
        @Bind(R.id.ratingTextView) TextView myRatingTextView;

        private Context myContext;

        public RestaurantViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            myContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosotion = getLayoutPosition();
            Intent intent = new Intent(myContext, RestaurantDetailActivity.class);
            intent.putExtra("position",itemPosotion);
            intent.putExtra("restaurants", Parcels.wrap(myRestaurants));
            myContext.startActivity(intent);
        }

        public void bindRestaurant(Restaurant restaurant){
            Picasso.with(myContext).load(restaurant.getImageUrl()).into(myRestaurantImageView);
            myNameTextView.setText(restaurant.getName());
            myCategoryTextView.setText(restaurant.getCategories().get(0));
            myRatingTextView.setText("Rating: "+ restaurant.getRating() + "/5");
        }
    }
}
