package com.epicodus.myrestaurants.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.myrestaurants.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.locationEditText) EditText myLocationEditText;
    @Bind(R.id.myRestaurantsButton) Button myFinRestaurantsButton ;
    @Bind(R.id.textView) TextView myFindRestaurantsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrichregular.ttf");
        myFindRestaurantsTextView.setTypeface(ostrichFont);
        myFinRestaurantsButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        if (v == myFinRestaurantsButton) {
            String location = myLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RestaurantsListActivity.class);
            intent.putExtra("Location", location);
            startActivity(intent);
        }
    }
}
