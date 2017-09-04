package com.epicodus.myrestaurants.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.myrestaurants.R;
import com.epicodus.myrestaurants.models.Restaurant;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantDetailFragment extends Fragment {
    @Bind(R.id.restaurantImageView) ImageView myImageLabel;
    @Bind(R.id.restaurantNameTextView) TextView myNameLabel;
    @Bind(R.id.cuisineTextView) TextView myCategoriesLabel;
    @Bind(R.id.ratingTextView) TextView myRatingLabel;
    @Bind(R.id.websiteTextView) TextView myWebsiteLabel;
    @Bind(R.id.phoneTextView) TextView myPhoneLabel;
    @Bind(R.id.addressTextView) TextView myAddressLabel;
    @Bind(R.id.saveRestaurantButton) TextView mySaveRestaurantButton;

    private Restaurant myRestaurant;

    public static RestaurantDetailFragment newInstance(Restaurant restaurant){
        RestaurantDetailFragment restaurantDetailFragment = new RestaurantDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("restaurant", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        myRestaurant = Parcels.unwrap(getArguments().getParcelable("restaurant"));
    }


    public RestaurantDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_detail,container,false);
        ButterKnife.bind(this,view);
        Picasso.with(view.getContext()).load(myRestaurant.getImageUrl()).into(myImageLabel);
        myNameLabel.setText(myRestaurant.getName());
        myCategoriesLabel.setText(android.text.TextUtils.join(", ", myRestaurant.getCategories()));
        myRatingLabel.setText(Double.toString(myRestaurant.getRating()) + "/5");
        myPhoneLabel.setText(myRestaurant.getPhone());
        myAddressLabel.setText(android.text.TextUtils.join(", ", myRestaurant.getAddress()));

        return view;
    }

}
