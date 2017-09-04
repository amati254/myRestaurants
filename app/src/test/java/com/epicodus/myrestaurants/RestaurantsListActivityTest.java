package com.epicodus.myrestaurants;

import android.os.Build;
import android.widget.ListView;

import com.epicodus.myrestaurants.ui.RestaurantsListActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class RestaurantsListActivityTest {
    private RestaurantsListActivity activity;
    private ListView myRestaurantsListView;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(RestaurantsListActivity.class);
    }

    @Test
    public void restaurantListViewPopulates(){
        assertNotNull(myRestaurantsListView.getAdapter());
        assertEquals(myRestaurantsListView.getAdapter().getCount(),15);
    }

}
